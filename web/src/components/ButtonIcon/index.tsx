import ArrowIcon from '../../assets/imgs/play.png'
import './styles.css'

const ButtonIcon = () => {
  return (
    <div className="btn-container">
      <button className="btn">
        <h6>Explorar GameQuest</h6>
      </button>

      <div className="btn-icon-container">
        <img src={ArrowIcon} alt="" />
      </div>
    </div>
  )
}

export default ButtonIcon