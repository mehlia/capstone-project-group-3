import { useContext } from "react";
import { Outlet } from "react-router";
import { GlobalUserContext } from "../containers/PapierContainer";


const UserHome = () => {

    const {globalUser} = useContext(GlobalUserContext) || {};

    console.log(globalUser)
    return ( 
        <>
            <h1> This is the user home   </h1>
            <Outlet/>
        </>
    );
}

export default UserHome;