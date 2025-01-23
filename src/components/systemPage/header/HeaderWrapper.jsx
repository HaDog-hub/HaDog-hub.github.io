import HeaderButton from "./HeaderButton";
import UserList from "./UserList";

/* eslint-disable react/prop-types */
function HeaderWrapper({ fullTogglePage, user }) {
  return (
    <div className="header-wrapper">
      <button className="front-page-button">首頁</button>
      {user.role == 3 && <HeaderButton label={"帳號管理"} />}
      {user.role == 3 && <HeaderButton label={"科別管理"} />}
      {user.role == 3 && <HeaderButton label={"手術房管理"} />}
      {user.role >= 2 && <HeaderButton label={"手術管理"} />}
      {user.role == 3 && <HeaderButton label={"排班管理"} />}
      <UserList fullTogglePage={fullTogglePage} name={user.name} />
    </div>
  );
}

export default HeaderWrapper;
