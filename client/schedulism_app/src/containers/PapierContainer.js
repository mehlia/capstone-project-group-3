import { useState, useEffect, createContext } from "react";
import UserList from "../component/UserList";
import NewUserForm from "../component/NewUserForm";
import LogInForm from "../component/LogInForm";
import { createBrowserRouter, json, RouterProvider } from "react-router-dom";
import UserHome from "../component/UserHome";
import NavBar from "../component/NavBar";
import { Outlet } from "react-router-dom";

export const ClientUserContext = createContext();

const PapierContainer = () => {
    
    const [users, setUsers] = useState([]);
    const [shifts, setShifts] = useState(null);
    const [userToFind, setUserToFind] = useState(null);
    const [globalUser, setGlobalUser] = useState([{
            name: null,
            id: null,
            email: null,
            occupation: null,
            user_role: null,
            username: null
        }]);

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

    const fetchAllUserShifts = async (shiftRotationId, requesterId) => {
        const response = await fetch(`http://localhost:8080/shift-rotations/${shiftRotationId}/users/${requesterId}`);
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
            user_role: jsonData.user_role,
            username: jsonData.username
        })
    }

    useEffect(() => {
        // fetchAllUsers(1);
        // fetchAllUserShifts(1,1);
        // fetchUserById(1,3);
    },[])


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
                    <> 
                    <ClientUserContext.Provider value={globalUser}> 
                    <LogInForm updateGlobalUser={updateGlobalUser}/>
                    </ClientUserContext.Provider>
                    </>
                },
                    
                {    
                    path: "/user-home",
                    element: 
                    <>
                    <ClientUserContext.Provider value={globalUser}> 
                    <UserHome />
                    </ClientUserContext.Provider>
                    </>
                }
            ]
        }
    ])

    return ( 
    <>
        <RouterProvider router={userRoutes} />
    </> 
    );
}

export default PapierContainer;