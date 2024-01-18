import React, { useContext } from "react";
import { Link } from "react-router-dom";
import { GlobalUserContext } from "../containers/PapierContainer";
import smallLogo from "../assets/smallLogo.png";

const NavBar = () => {
 const { globalUser } = useContext(GlobalUserContext);

 const renderHRNav = () => (
   <>
     <li>
       <Link to="/user-home">Home</Link>
     </li>
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
       <Link to="/">Sign Out</Link>
     </li>
   </>
 );

 const renderRegularNav = () => (
   <>
     <li>
       <Link to="/user-home">Home</Link>
     </li>
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
       <Link to="/">Sign Out</Link>
     </li>
   </>
 );

 return (
   <nav className="nav">
    <img className="small-logo" src={smallLogo} alt="schedulism mini-logo" />
     <ul>
       {globalUser.userRole === "HR_EMPLOYEE" ? renderHRNav() : renderRegularNav()}
     </ul>
   </nav>
 );
};

export default NavBar;