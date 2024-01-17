import { useState, useEffect, createContext } from "react";
import UserList from "../component/UserList";
import NewUserForm from "../component/NewUserForm";
import LogInForm from "../component/LogInForm";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import UserHome from "../component/UserHome";
import NavBar from "../component/NavBar";
import Shift from "../component/Shift";
import ShiftList from "../component/ShiftList";
import User from "../component/User";

export const GlobalUserContext = createContext({
   globalUser: {},
   setGlobalUser:()=>{}
});

const PapierContainer = () => {
   
   const [users, setUsers] = useState([]);
   const [shifts, setShifts] = useState([]);
   const [userToFind, setUserToFind] = useState(null);
   const [globalUser, setGlobalUser] = useState({
           name: "",
           id: 0,
           email: "",
           occupation: "",
           userRole: "",
           username: "",
           shiftRotations: []
       });

   const fetchAllUsers = async (requesterId) => {
       const response = await fetch(`http://localhost:8080/users/${requesterId}`);
       const jsonData = await response.json();
       setUsers(jsonData);
   }

   const fetchUserById = async (requesterId, idToFind) => {
       const response = await fetch(`http://localhost:8080/users/${requesterId}/find/${idToFind}`);
       const jsonData = await response.json();
       setUserToFind(jsonData);
   }

   const fetchAllUserShifts = async (userId) => {
       const response = await fetch(`http://localhost:8080/users/${userId}/shift-rotations`);
       const jsonData = await response.json();
       setShifts(jsonData);
   }

   const updateGlobalUser = async (userId) => {
       const response = await fetch(`http://localhost:8080/users/${userId}/find/${userId}`);
       const jsonData = await response.json();
       setGlobalUser({
           name: jsonData.name,
           id: jsonData.id,
           email: jsonData.email,
           occupation: jsonData.occupation,
           userRole: jsonData.userRole,
           username: jsonData.username,
           shiftRotations: jsonData.shiftRotations
       });
       
       fetchAllUserShifts(userId);
       fetchAllUsers(userId);
   }

   const deleteUserById = async (userToDelete, requesterId) => {
    try{
        if (globalUser.userRole == "EMPLOYEE") {
            requesterId = userToDelete;
        } else {
            requesterId = globalUser.id;
        }
        console.log(requesterId,userToDelete);
        const response = await fetch(`http://localhost:8080/users/${requesterId}/${userToDelete}`,
        {
        method: "DELETE",
        headers: { "Content-Type": "application/json" }
        }
        );
        console.log("after delete msg")
        if (response.status === 204) {
            console.log("after if statement")
            alert('Account deleted successfully!');
            setGlobalUser(null);
            setShifts([]);
        } else {
            console.error('Failed to delete account. Status code:', response.status);
        }
    
    } catch (error) {
        console.error('Failed to delete account:', error);
    }
  };

   useEffect(() => {
       // fetchAllUsers(1);
       // fetchAllUserShifts(globalUser.id); //revise this later
       // fetchUserById(1,3);
   },[globalUser.id])

   return ( 
    <>
        <GlobalUserContext.Provider value={{globalUser, setGlobalUser}}> 
            <Router>
                <NavBar /> 
                <Routes>
                  <Route path="/" element={<LogInForm updateGlobalUser={updateGlobalUser}/>} />
                  <Route path="/user-home" element={<UserHome />} />
                  {/* <Route path="/my-info" element={<UserList users = {users} />} /> */}
                  <Route path="/my-shifts" element={<ShiftList shifts = {shifts} userId={globalUser.id}/>} />
                  <Route path="/personal-info" element={<User useDelete={false} useTitle={true} />} />
                  <Route path="/view-all-employees" element={<UserList users = {users} allUsers = {users} deleteUserById={deleteUserById} />} />
                  <Route path="/delete-account" element={<User useDelete={true} useTitle={false} deleteUserById={deleteUserById}/>} />
                  <Route path="/" element={<></>} />
                </Routes>
            </Router>
        </GlobalUserContext.Provider>
    </> 
    );
  }

export default PapierContainer;