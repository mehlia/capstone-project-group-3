import React, { useContext } from "react";
import { Link } from "react-router-dom";
import { GlobalUserContext } from "../containers/PapierContainer";

const NavBar = () => {
  const { globalUser } = useContext(GlobalUserContext);

  const renderHRNav = () => (
    <>
      <li>
        <Link to="/personal-info">Personal Info</Link>
      </li>
      <li>
        <Link to="/my-shifts">My Shifts</Link>
      </li>
      <li>
        <Link to="/view-all-employees">View All Employees</Link>
      </li>
      <li>
        <Link to="/delete-account">Delete Account</Link>
      </li>
      <li>
        <Link to="/sign-out">Sign Out</Link>
      </li>
    </>
  );

  const renderRegularNav = () => (
    <>
      <li>
        <Link to="/personal-info">Personal Info</Link>
      </li>
      <li>
        <Link to="/my-shifts">My Shifts</Link>
      </li>
      <li>
        <Link to="/delete-account">Delete Account</Link>
      </li>
      <li>
        <Link to="/sign-out">Sign Out</Link>
      </li>
    </>
  );

  return (
    <nav>
      <ul>
        {globalUser.userRole === "HR" ? renderHRNav() : renderRegularNav()}
      </ul>
    </nav>
  );
};

export default NavBar;
