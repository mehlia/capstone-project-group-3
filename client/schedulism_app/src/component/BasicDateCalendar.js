import * as React from 'react';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { DesktopDatePicker } from '@mui/x-date-pickers/DesktopDatePicker';
import TextField from '@mui/material/TextField';

export default function BasicDateCalendar({ shifts }) {
 return (
   <LocalizationProvider dateAdapter={AdapterDayjs}>
     {(shifts ? shifts : []).map((shift, index) => (
       <DesktopDatePicker
         key={index}
         label={`Shift ${index + 1}`}
         inputFormat="MM/dd/yyyy"
         value={shift.date}
         renderInput={(params) => <TextField {...params} />}
       />
     ))}
   </LocalizationProvider>
 );
}
