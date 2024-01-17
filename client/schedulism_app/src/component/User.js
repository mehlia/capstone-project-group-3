import { useContext } from "react";
import { GlobalUserContext } from "../containers/PapierContainer";


const User = ({user}) => {

  const {globalUser} = useContext(GlobalUserContext);

  const userOne = user ? user : globalUser;

    return (
        <div className="user">
        <h3>My Personal Information</h3>
        <p>Name: {userOne.name}</p>
        <p>Email Address: {userOne.email}</p>
        <p>Username: {userOne.username}</p>
        <p>Occupation: {userOne.occupation}</p>
        </div>
      );
}
 
export default User;
