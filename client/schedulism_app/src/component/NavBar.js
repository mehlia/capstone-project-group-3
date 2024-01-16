import MultilevelSidebar from "react-multilevel-sidebar";
import "react-multilevel-sidebar/src/Sidebar.css";
import { Sidebar, Menu, MenuItem } from "react-multilevel-sidebar";
import { GlobalUserContext } from "../containers/PapierContainer";
import { useContext } from "react";

const NavBar = () => {
  const { globalUser } = useContext(GlobalUserContext);

  let options;
  if (globalUser.user_role === "EMPLOYEE") {
    options = [
      {
        title: "Home",
        content: [{ id: 1, name: "Home", to: "/home" }], //Make sure to include icons, titleIcon
      },
      {
        title: "Personal Info",
        content: [{ id: 2, name: "Personal Info", to: "/my-info" }],
      },
      {
        title: "My Shifts",
        content: [{ id: 3, name: "My Shifts", to: "/my-shifts" }],
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
        content: [{ id: 6, name: "Sign Out", to: "/sign-out" }],
      },
    ];
  } else if (globalUser.user_role === "HR_EMPLOYEE") {
    options = [
      {
        title: "Home",
        content: [{ id: 1, name: "Home", to: "/home" }], //Make sure to include icons, titleIcon
      },
      {
        title: "Personal Info",
        content: [{ id: 7, name: "Personal Info", to: "/my-info" }],
      },
      {
        title: "My Shifts",
        content: [{ id: 8, name: "My Shifts", to: "/my-shifts" }],
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
        content: [{ id: 15, name: "Sign Out", to: "/sign-out" }],
      },
    ];
  }

  return (
    <>
      <h1>This is the nav bar</h1>
      <MultilevelSidebar
        open={true}
        onToggle={() => {}}
        options={options}
        header="Navigation"
        onItemClick={() => {}}
      />
    </>
  );
};

export default NavBar;
