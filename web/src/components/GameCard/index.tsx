import "./styles.css";
import GameImg from "../../assets/imgs/gameimg.png";
import axios from "axios";
import { BASE_URL } from "../../utils/request";

const GameCard = () => {
  axios.get(BASE_URL + "/api/games").then((response) => {
    console.log(response.data);
  });
  return (
    <div className="game-card">
      <div className="img-card-game">
        <img src={GameImg} />
      </div>
      <div className="game-card-bottom">
        <h6>Resident evil 3</h6>
        <div className="rating-card-game">
          <p>NOTA:</p>
          <p className="grade-card">6.00</p>
        </div>
      </div>
    </div>
  );
};

export default GameCard;
