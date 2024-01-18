import { useContext } from "react";
import { GlobalUserContext } from "../containers/PapierContainer";
import { useNavigate } from "react-router-dom";


const User = ({user, useDelete, useTitle, deleteUserById}) => {

  const {globalUser} = useContext(GlobalUserContext);

  const navigate = useNavigate();

  const userOne = user ? user : globalUser;

  const handleDeleteButton = () => {
    deleteUserById(globalUser.id,userOne.id);
    navigate("/user-home");
  }

    return (
        <div className="user">
        {useTitle ? (
        <h3>Personal info</h3>
        ) : null}        <p>Name: {userOne.name}</p>
        <p>Email Address: {userOne.email}</p>
        <p>Username: {userOne.username}</p>
        <p>Occupation: {userOne.occupation}</p>
        {useDelete ? (
        <button onClick={handleDeleteButton} >Delete</button>
        ) : null}
        </div>
      );
}
 
export default User;
