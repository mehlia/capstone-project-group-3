import { Outlet } from "react-router-dom";

const Shift = ({shift}) => {
    

    return ( 
    <div className="shift">
        <h3>Test Shifts</h3>
        <p>date:{shift.date}</p>
        <p>Type of Shift:{shift.shiftType.shiftSlot}</p>
        <p>Start Time: {shift.shiftType.startTime}</p>  
        <p>End Time: {shift.shiftType.endTime}</p>
    </div> );
    // <Outlet/>
}
 
export default Shift;