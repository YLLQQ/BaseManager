import welcome from '@/assets/welcome.png';
export default () => (
  <div style={{position: 'absolute', top: '50%', left: '50%', transform: 'translate(-50%, -50%)', marginLeft: '100px'}}>
    <img src={welcome} alt="欢迎" />
  </div>
);