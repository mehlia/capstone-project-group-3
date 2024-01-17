import User from "./User";

const UserList = ({users, allUsers}) => {

    console.log(users, allUsers);

    const mappedUsers = users.map((user) =>{
        return <User
        key = {user.id}
        user = {user}
        />
      })

    return (
        <>
        <h2>All Employees</h2>
        {mappedUsers} 
        </>
    );
}

export default UserList;