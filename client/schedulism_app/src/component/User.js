import { useContext } from "react";
import { GlobalUserContext } from "../containers/PapierContainer";


const User = ({user}) => {

  const {globalUser} = useContext(GlobalUserContext);
    return (
        <div className="user">
        <h3>My Personal Information</h3>
        <p>Name: {globalUser.name}</p>
        <p>Email Address: {globalUser.email}</p>
        <p>Username: {globalUser.username}</p>
        <p>Occupation: {globalUser.occupation}</p>
        </div>
      );
}
 
export default User;
