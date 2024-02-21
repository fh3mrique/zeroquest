import "./styles.css";
import Logo from "../../assets/imgs/logo.png";
import { Link } from "react-router-dom";

const Header = () => {
  return (
    <nav className="nav-bar">
      <div className="container-header-fluid">
        <Link to="/" className="custom-link">
          <div className="nav-logo-header">
            <img src={Logo} alt="" />
            <h1>GameQuest</h1>
          </div>
        </Link>

        <div className="nav-menu-header">
          <ul className="navbar-nav offset-md-2 main-menu">
            <li>
              <a>HOME</a>
            </li>
            <li>
              <a>CATÁLOGO</a>
            </li>
            <li>
              <a>ADMIN</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Header;
