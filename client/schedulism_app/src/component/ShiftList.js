import Shift from "./Shift";
import { Calendar, momentLocalizer } from "react-big-calendar";
import "react-big-calendar/lib/css/react-big-calendar.css";
import moment from "moment";
import Modal from "react-modal";
import { useState } from "react";

const ShiftList = ({ shifts }) => {
  const localizer = momentLocalizer(moment);

  const [selectedShift, setSelectedShift] = useState(null);
  const [isModalOpen, setIsModalOpen] = useState(false);

  const formatShiftTime = (time) => {
    return moment(time, 'HH:mm').format('LT'); 
  };

  // const eventPropGetter = (event, isSelected) => {
  //   return {
  //     style: {
  //       backgroundColor: isSelected ? 'lightblue' : event.shift.is_approved ? 'green' : 'orange',
  //     },
  //   };
  // };

  const parseTimeStringToDate = (timeString) => {
    console.log(timeString)
    const [hours, minutes, seconds] = timeString.split(':');
    const currentDate = new Date();
    console.log(hours,minutes,seconds)
    currentDate.setHours(Number(hours));
    currentDate.setMinutes(Number(minutes));
    currentDate.setSeconds(Number(seconds));
    console.log(currentDate)
    return currentDate;
  };

  const events = shifts.map((shift) => (
    
    {
    id: shift.id,
    title: `${shift.shiftType.shiftSlot} : ${formatShiftTime(shift.shiftType.startTime)} - ${formatShiftTime(shift.shiftType.endTime)}`,
    start: parseTimeStringToDate(shift.shiftType.startTime),
    end: parseTimeStringToDate(shift.shiftType.endTime),
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
        style={{ height: 500 }}
        onSelectEvent={handleEventClick}
        //eventPropGetter={eventPropGetter} // takes in ShiftType rather than shiftRotation so can't use this for showing available shifts
      />
      <Modal
        isOpen={isModalOpen}
        onRequestClose={() => setIsModalOpen(false)}
        contentLabel="Shift Details"
        style={{
          overlay: {
            zIndex: 1000,
          },
          content: {
            zIndex: 1001,
          },
        }}
      >
        {selectedShift && (
          <div>
            <h2>Shift Details</h2>
            <p>Date: {moment(selectedShift.start).format("MMMM DD, YYYY")}</p>
            <p>Type of Shift: {selectedShift.title}</p>
          </div>
        )}
      </Modal>
    </>
  );
};

export default ShiftList;
