import { useState, useEffect } from "react";
import UserList from "../component/UserList";

const PapierContainer = () => {
    
    const [user, setUsers] = useState([]);

    const fetchAllUsers = async () => {
        const response = await fetch(`http://localhost:8080/users/1`);
        const jsonData = await response.json();
        setUsers([...jsonData]);
        console.log(jsonData);
    }

    useEffect(() => {
        fetchAllUsers()
    },[])

    return ( 
    <>
        <h1>This is the container</h1>
        <UserList />

    </> 
    );
}

export default PapierContainer;