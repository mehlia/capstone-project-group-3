import Shift from "./Shift";
import * as React from "react";
import { LocalizationProvider } from "@mui/x-date-pickers/LocalizationProvider";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { DateCalendar } from "@mui/x-date-pickers/DateCalendar";
import { useState } from 'react';
import BasicDateCalendar from "./BasicDateCalendar";

const ShiftList = ({ shifts }) => {
  const [selectedDate, setSelectedDate] = useState(null);

  const mappedShifts = shifts.map((shift) => {
    // Check if the shift matches the selected date
    if (!selectedDate || shift.date === selectedDate) {
      return <Shift key={shift.id} shift={shift} />;
    }
    return null;
  });

  return (
    <>
      <h2> My Schedule</h2>
      <BasicDateCalendar onDateChange={setSelectedDate} />
      {mappedShifts}
    </>
  );
};

export default ShiftList;
