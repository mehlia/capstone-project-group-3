import Shift from "./Shift";
import { Calendar, momentLocalizer } from 'react-big-calendar';
import 'react-big-calendar/lib/css/react-big-calendar.css';
import moment from 'moment';
import Modal from 'react-modal';
import { useState } from "react";


// const ShiftList = ({shifts}) => {

//     const mappedShifts = shifts.map((shift) =>{
//       return <Shift
//       key = {shift.id}
//       shift = {shift}
//       />
//     }) 
//     return ( 
//         <>
//             <h2> My Schedule</h2>
//             {mappedShifts}
//         </>
//     );
// }

// export default ShiftList;

const ShiftList = ({ shifts }) => {
    const localizer = momentLocalizer(moment);
  
    const [selectedShift, setSelectedShift] = useState(null);
    const [isModalOpen, setIsModalOpen] = useState(false);

    const events = shifts.map((shift) => ({
      id: shift.id,
      title: shift.shiftType.shiftSlot,
      start: new Date(shift.date),
      end: moment(shift.date)
        .add(1, 'day') // Assuming shifts are for the entire day, you can adjust this based on your requirements
        .toDate(),
    }));
  
    const handleEventClick = (event) => {
        setSelectedShift(event);
        setIsModalOpen(true);
      };
      
    return (
      <>
        <h2>My Schedule</h2>
        <Calendar
          localizer={localizer}
          events={events}
          startAccessor="start"
          endAccessor="end"
          style={{ height: 500 }} // Adjust the height as needed
          onSelectEvent={handleEventClick} // Add this line to handle event click
        />
        <Modal
        isOpen={isModalOpen}
        onRequestClose={() => setIsModalOpen(false)}
        contentLabel="Shift Details"
        >
        {selectedShift && (
        <div>
        <h2>Shift Details</h2>
        <p>Date: {moment(selectedShift.start).format('MMMM DD, YYYY')}</p>
        <p>Type of Shift: {selectedShift.title}</p>
        {/* Add other shift details as needed */}
        </div>
        
    )}</Modal>
      </>
    );
  };
  
  export default ShiftList;
  