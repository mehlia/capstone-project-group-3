import MultilevelSidebar from "react-multilevel-sidebar";
import "react-multilevel-sidebar/src/Sidebar.css";
import { Sidebar, Menu, MenuItem } from "react-multilevel-sidebar";
import { GlobalUserContext } from "../containers/PapierContainer";
import { useContext, useEffect, useState } from "react";
import { Link, Outlet } from "react-router-dom";
import ShiftList from "./ShiftList";

const NavBar = () => {
  const { globalUser } = useContext(GlobalUserContext) || {};
  const [isOpen, setIsOpen] = useState(false);
  const [showUserShifts, setShowUserShifts] = useState(false);

//   const handleMyShiftsClick = () => {
//    setMyShiftsOpen(!myShiftsOpen) 
// }



  let options = [];
  if (globalUser && globalUser.userRole === "EMPLOYEE") {
      options = [
      {
        title: "Home",
        content: [{ id: 1, name: "Home", to: "/home" }], 
      },
      {
        title: "Personal Info",
        content: [{ id: 2, name: "Personal Info", to: "/my-info" }],
      },
      {
        title: "My Shifts",
        content: [{ id: 3, name: "My Shifts", onClick: () => setShowUserShifts(true),to: "/my-shifts"}],
      },
      {
        title: "Available Shifts",
        content: [{ id: 4, name: "Available Shifts", to: "/available-shifts" }],
      },
      {
        title: "Delete Account",
        content: [{ id: 5, name: "Delete Account", to: "/delete-account" }],
      },
      {
        title: "Sign Out",
        content: [{ id: 6, name: "Sign Out", to: "/" }],
      },
    ];
  } else if (globalUser && globalUser.userRole === "HR_EMPLOYEE") {
    options = [
      {
        title: "Home",
        content: [{ id: 1, name: "Home", to: "/home" }],
      },
      {
        title: "Personal Info",
        content: [{ id: 7, name: "Personal Info", to: "/my-info" }],
      },
      {
        title: "My Shifts",
        content: [{ id: 8, name: "My Shifts", onClick: () => setShowUserShifts(true), to: "/my-shifts"}],
      },
      {
        title: "Available Shifts", //Ensure that some titles are under one catergory
        content: [{ id: 9, name: "Available Shifts", to: "/available-shifts" }],
      },
      {
        title: "View All Employees",
        content: [{ id: 10, name: "View All Employees", to: "/all-employees" }],
      },
      {
        title: "View All Employee Shifts",
        content: [
          {
            id: 11,
            name: "View All Employee Shifts",
            to: "/all-employee-shifts",
          },
        ],
      },
      {
        title: "View Shift Requests",
        content: [{ id: 12, name: "View Shift Requests", to: "/requests" }],
      },
      {
        title: "Add New Employee",
        content: [
          { id: 13, name: "Add New Employee", to: "/add-new-employee" },
        ],
      },
      {
        title: "Delete Account",
        content: [{ id: 14, name: "Delete Account", to: "/delete-account" }],
      },
      {
        title: "Sign Out",
        content: [{ id: 15, name: "Sign Out", to: "/" }],
      },
    ];
  }

  return (
    <>
         
    <MultilevelSidebar
        open={isOpen}
        onToggle={() => setIsOpen(!isOpen)}
        options={options}
        header="Schedulism"
        // onItemClick={handleClick}
      />

      <button onClick={() => setIsOpen(true)}>open</button>
      {showUserShifts && globalUser && (
        <ShiftList shifts={globalUser.shiftRotations} userId={globalUser.id} />
      )}
    </>
  );
};


export default NavBar;