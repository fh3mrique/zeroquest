import HomeImg from '../../assets/imgs/homeimg.png'
import ButtonIcon from '../../components/ButtonIcon';
import './styles.css'

const Home = () => {
  return (
    <div className="home-container">
      <div className="home-text">
        <div className="home-title">
          <h1>GERENCIE SUA BIBLIOTECA DE CONQUISTAS VIRTUAIS</h1>
        </div>

        <div className="home-subtext">
          <p>
            Seu gerenciador pessoal de jogos zerados: controle, avalie e
            registre suas experiências.
          </p>
        </div>

        <div className="btn-home-container">
          <ButtonIcon/>
        </div>
      </div>

      <div className="home-img-container">
        <img src={HomeImg} alt="" />
      </div>
    </div>
  );
};

export default Home;
