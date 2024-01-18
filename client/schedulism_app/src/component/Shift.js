import { Outlet } from "react-router-dom";

const Shift = ({shift}) => {
    
    console.log("Log in Shift.js", shift);  

    return ( 
    <div className="shift">
        
        <h3>date:{shift.date}</h3>
        <p>Type of Shift:{shift.shiftType.shiftSlot}</p>
        <p>Start Time: {shift.shiftType.startTime}</p>  
        <p>End Time: {shift.shiftType.endTime}</p>
    </div> );
    // <Outlet/>
}
 
export default Shift;