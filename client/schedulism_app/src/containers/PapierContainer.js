import { useState, useEffect, createContext } from "react";
import UserList from "../component/UserList";
import NewUserForm from "../component/NewUserForm";
import LogInForm from "../component/LogInForm";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import UserHome from "../component/UserHome";

const PapierContainer = () => {
    
    const [users, setUsers] = useState([]);
    const [shifts, setShifts] = useState(null);
    const [userToFind, setUserToFind] = useState(null);

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

    useEffect(() => {
        fetchAllUsers(1);
        fetchAllUserShifts(1,1);
        fetchUserById(1,3);
    },[])


    const userRoutes = createBrowserRouter ([
        {
            path: "/",
            element: <LogInForm />,
            children: [
                // Add more children next 
                {
                    path: "/user-home",
                    element: <UserHome />
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