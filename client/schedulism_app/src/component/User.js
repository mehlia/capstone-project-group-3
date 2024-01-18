import { useContext, useState } from "react";
import { GlobalUserContext } from "../containers/PapierContainer";
import { useNavigate } from "react-router-dom";
import Modal from "@mui/material/Modal";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";

// const User = ({ user, useDelete, useTitle, deleteUserById }) => {
//   let { globalUser } = useContext(GlobalUserContext);

//   const navigate = useNavigate();

//   const userOne = user ? user : globalUser;

//   const handleDeleteButton = () => {
//     deleteUserById(globalUser.id, userOne.id);


//     if (userOne.id === globalUser.id) {
//       navigate("/");
//       globalUser = {
//         name: "",
//         id: 0,
//         email: "",
//         occupation: "",
//         userRole: "",
//         username: "",
//         shiftRotations: [],
//       };
//     } else {
//       navigate("/user-home");
//     }
// };

//   return (
//     <div className="user">
//       <h3>Details</h3>
//       {useTitle ? <h3>Personal info</h3> : null} <p>Name: {userOne.name}</p>
//       <p>Email Address: {userOne.email}</p>
//       <p>Username: {userOne.username}</p>
//       <p>Occupation: {userOne.occupation}</p>
//       {useDelete ? <button onClick={handleDeleteButton}>Delete</button> : null}
//     </div>
//   );

// };

// export default User;


const User = ({ user, useDelete, useTitle, deleteUserById }) => {
  const { globalUser } = useContext(GlobalUserContext);
  const navigate = useNavigate();
  const userOne = user ? user : globalUser;

  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleDeleteButton = () => {
    setIsModalOpen(true);
  };

  const handleConfirmDelete = () => {
    deleteUserById(globalUser.id, userOne.id);
    if (userOne.id === globalUser.id) {
      navigate("/");
    } else {
      navigate("/user-home");
    }
    setIsModalOpen(false);
  };

  const handleCancelDelete = () => {
    setIsModalOpen(false);
  };

  return (
    <div className="user">
      <h3>Details</h3>
      {useTitle ? (
        <h3>Personal info</h3>
      ) : null}
      <p>Name: {userOne.name}</p>
      <p>Email Address: {userOne.email}</p>
      <p>Username: {userOne.username}</p>
      <p>Occupation: {userOne.occupation}</p>
      {useDelete ? (
        <>
          <Button onClick={handleDeleteButton}>Delete</Button>
          <Modal
            open={isModalOpen}
            onClose={handleCancelDelete}
            style={{
              display: 'flex',
              alignItems: 'center',
              justifyContent: 'center',
            }}
          >
            <Box style={{ width: 400, padding: 16, background: 'white' }}>
              <h3>Are you sure you want to delete the account?</h3>
              <Button onClick={handleConfirmDelete}>Yes</Button>
              <Button onClick={handleCancelDelete}>No</Button>
            </Box>
          </Modal>
        </>
      ) : null}
    </div>
  );
};

export default User;

