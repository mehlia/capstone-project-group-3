import { useState, useEffect, createContext } from "react";
import UserList from "../component/UserList";
import NewUserForm from "../component/NewUserForm";
import LogInForm from "../component/LogInForm";
import { createBrowserRouter, json, RouterProvider } from "react-router-dom";
import UserHome from "../component/UserHome";
import NavBar from "../component/NavBar";
import { Outlet } from "react-router-dom";
import Shift from "../component/Shift";
import ShiftList from "../component/ShiftList";

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
        setUsers([...jsonData]);
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
    
    


    }

    useEffect(() => {
        // fetchAllUsers(1);
        // fetchAllUserShifts(globalUser.id);  //revise this later
        // fetchUserById(1,3);
    },[globalUser.id])


    const userRoutes = createBrowserRouter ([
        {
            path: "/",
            element:
            <>
                <NavBar /> 
                <Outlet /> {/* To make sure it loads the log-in form */}
            </> ,
            children: 
            [
                // Add more children next 
                {
                    path: "/",
                    element:
                    <LogInForm updateGlobalUser={updateGlobalUser}/>
                },
                    
                {    
                    path: "/user-home",
                    element: 
                    <UserHome />
                },

                {    
                    path: "/my-shifts",
                    element: 
                    <ShiftList shifts = {shifts}/>
                }

            
            ]
        }
    ])

    return ( 
    <>
        <GlobalUserContext.Provider value={{globalUser, setGlobalUser}}> 
            <RouterProvider router={userRoutes} />
        </GlobalUserContext.Provider>
    </> 
    );
}

export default PapierContainer;