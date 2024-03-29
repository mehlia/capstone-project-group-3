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
        
            {mappedUsers} 
        
        
        </>
    );
}
<footer className="footer">
<p> 2024 Madame Papier All Rights Reserved, Otherwise We Will Be Suing &#174;</p>
</footer>
export default UserList;