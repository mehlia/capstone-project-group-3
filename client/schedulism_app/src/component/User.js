import { useContext } from "react";
import { GlobalUserContext } from "../containers/PapierContainer";


const User = ({user, useDelete, useTitle}) => {

  const {globalUser} = useContext(GlobalUserContext);

  const userOne = user ? user : globalUser;

    return (
        <div className="user">
        {useTitle ? (
        <h3>Personal info</h3>
        ) : null}        <p>Name: {userOne.name}</p>
        <p>Email Address: {userOne.email}</p>
        <p>Username: {userOne.username}</p>
        <p>Occupation: {userOne.occupation}</p>
        {useDelete ? (
        <button type="button">Delete</button>
        ) : null}
        </div>
      );
}
 
export default User;
