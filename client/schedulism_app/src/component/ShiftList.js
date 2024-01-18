import Shift from "./Shift";

const ShiftList = ({shifts}) => {

    const mappedShifts = shifts.map((shift) =>{
      return <Shift
      key = {shift.id}
      shift = {shift}
      />
    }) 
    return ( 
        <>
            <h2> My Schedule</h2>
            {mappedShifts}
        </>
    );
}

export default ShiftList;