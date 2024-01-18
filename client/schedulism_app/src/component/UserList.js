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
        <div className="employee-list">
        <h2>All Employees</h2>
        {mappedUsers} 
        </div>
    );
}

export default UserList;