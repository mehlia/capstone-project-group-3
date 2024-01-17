const User = ({user}) => {

    return (
        <div className="user">
        <h3>My Personal Information</h3>
        <p>Name: {user.name}</p>
        <p>Email Address: {user.email}</p>
        <p>Username: {user.username}</p>
        <p>Occupation: {user.occupation}</p>
        </div>
      );
}
 
export default User;
