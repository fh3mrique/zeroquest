import "./styles.css";

const Header = () => {
  return (
    <header className="header-container">
      <div className="title-header-container">
        <div>
          <h1 className="logo-header">ZeroQuest</h1>
        </div>
      </div>

      <div className="right-options-header-container">
        <div className="options-header">
          <button className="">Cadastra-se</button>
          <button>Entrar</button>
        </div>
      </div>
    </header>
  );
};

export default Header;
