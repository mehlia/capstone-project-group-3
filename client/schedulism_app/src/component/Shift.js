const Shift = ({shift}) => {
    
console.log(shift)
    return ( 
    <div className="shift">
        <h3>My Shifts</h3>
        <p>date:{shift.date}</p>
        <p>Type of Shift:{shift.shiftType.shiftSlot}</p>
        <p>Start Time: {shift.shiftType.startTime}</p>  
        <p>End Time: {shift.shiftType.endTime}</p>
    </div> );

}
 
export default Shift;