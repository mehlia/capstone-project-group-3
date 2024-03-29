import Shift from "./Shift";
import * as React from "react";
import { LocalizationProvider } from "@mui/x-date-pickers/LocalizationProvider";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { DateCalendar } from "@mui/x-date-pickers/DateCalendar";
import { useState } from 'react';

const ShiftList = ({ shifts }) => {
  const [selectedDate, setSelectedDate] = useState(null);
  const mappedShifts = shifts.map((shift) => {
    // Checks to see if the shift matches the selected date
    if (!selectedDate || shift.date === selectedDate) {
      return <Shift key={shift.id} shift={shift} />;
    }
    return null;
  });
  return (
    <>
    <LocalizationProvider dateAdapter={AdapterDayjs}>
      <h2> My Schedule</h2>
      <DateCalendar
       date={selectedDate}
      onChange={(newDate) => setSelectedDate(newDate)}
      />
      {mappedShifts}
      </LocalizationProvider>
    </>
  );
};
<footer className="footer">
<p> 2024 Madame Papier All Rights Reserved, Otherwise We Will Be Suing &#174;</p>
</footer>
export default ShiftList;