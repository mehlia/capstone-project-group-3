import { useContext, useEffect,useState } from "react";
import { Outlet } from "react-router";
import { GlobalUserContext } from "../containers/PapierContainer";
import ShiftList from "./ShiftList";

const UserHome = () => {

    const {globalUser} = useContext(GlobalUserContext);
    const [userDetails, setUserDetails] = useState([]);
    const [shifts, setShifts] = useState([{
        date: null,
        approved_by_id: null,
        created_by_id: null,
        id: null,
        requested_by_id: null,
        shift_type_id: null,
        user_id: null
    }]);

    const getUserShifts = async () => {
        if(globalUser.id){
            setShifts(globalUser.shiftRotations);
            setUserDetails([
                globalUser.name, 
                globalUser.email,
                globalUser.occupation,
                globalUser.userRole,
                globalUser.username,
                globalUser.shiftRotations
            ])
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
            <ShiftList shifts={shifts} userId={globalUser.id}/>
            <Outlet/>
        </>
    );
}

export default UserHome;