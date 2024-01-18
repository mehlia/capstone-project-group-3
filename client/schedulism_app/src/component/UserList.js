import User from "./User";

const UserList = ({users, allUsers, deleteUserById}) => {


    const mappedUsers = users.map((user) =>{
        return <User
        key = {user.id}
        user = {user}
        useDelete={true}
        useTitle={false}
        deleteUserById={deleteUserById}
        />
      })

    return (
        <>
        <h2>All Employees</h2>
        <ul>
            {mappedUsers} 
        </ul>
        
        </>
    );
}

export default UserList;