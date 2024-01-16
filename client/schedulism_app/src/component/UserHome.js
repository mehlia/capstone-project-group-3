import { useContext, useEffect } from "react";
import { Outlet } from "react-router";
import { GlobalUserContext } from "../containers/PapierContainer";

const UserHome = () => {

    const {globalUser} = useContext(GlobalUserContext) || {};

    const getUserShifts = async () => {
        if(globalUser.id){
            const shifts = globalUser.shiftRotations;
            console.log(shifts);
        }
    }

    console.log("inUserHome", globalUser)

    useEffect(() => {
        getUserShifts();
    },[globalUser.id])

    return ( 
        <>
            <h1> This is the user home   </h1>
            <Outlet/>
        </>
    );
}

export default UserHome;