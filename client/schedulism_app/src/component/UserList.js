import User from "./User";

const UserList = ({users}) => {

    const mappedUsers = users.map((user) =>{
        return <User
        key = {user.id}
        user = {user}
        />
      })

    return (
        <>
        <h2>UserList</h2>
        {mappedUsers} 
        </>
    );
}

export default UserList;