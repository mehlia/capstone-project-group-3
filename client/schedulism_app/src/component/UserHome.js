import { useContext, useEffect,useState } from "react";
import { Outlet } from "react-router";
import { GlobalUserContext } from "../containers/PapierContainer";
import ShiftList from "./ShiftList";
import ShiftListHome from "./ShiftListHome";

const UserHome = () => {

    const {globalUser} = useContext(GlobalUserContext);
    const [userDetails, setUserDetails] = useState([]);
    const [shifts, setShifts] = useState([{
        approved: false,
        createdBy: 0,
        date: "",
        hasBeenRequested: false,
        id: 0,
        shiftType: {}
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


    useEffect(() => {
        getUserShifts();
    },[globalUser.id])

    return ( 
        <>
            <h1> Welcome {globalUser.name} </h1>

            <div className="parent-container">
                <div className="user-details ">
                    
                    <ul className="user-list-home"> 
                        <li>User: </li>
                        <li>{userDetails[1]}</li> 
                        <li>{userDetails[2]}</li> 
                        <li>{userDetails[3]}</li> 
                        <li>{userDetails[4]}</li> 
                    </ul>
                    </div>

            <div className="shift-details container">
                <ShiftListHome shifts={shifts} userId={globalUser.id}/>
            </div>
            </div>
            
            <footer>
                <p> 2024 Madame Papier All Rights Reserved, Otherwise We Will Be Sueing &#174;</p>
            </footer>
            <Outlet/>
        </>
    );
}

export default UserHome;