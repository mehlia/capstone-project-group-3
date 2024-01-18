const Shift = ({shift}) => {
    
    return ( 
    <div className="shift">
        <h3>Date: {shift.date}</h3>
        <p>Type of Shift: {shift.shiftType.shiftSlot}</p>
        <p>Start Time: {shift.shiftType.startTime}</p>  
        <p>End Time: {shift.shiftType.endTime}</p>
    </div> );

}
 
export default Shift;