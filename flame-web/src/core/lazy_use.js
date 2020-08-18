import Vue from 'vue'

// base library
import {
  Affix,
  Alert,
  Anchor,
  AutoComplete,
  Avatar,
  Badge,
  BackTop,
  Base,
  Breadcrumb,
  Button,
  Card,
  Carousel,
  Calendar,
  Cascader,
  Checkbox,
  Col,
  Collapse,
  Comment,
  ConfigProvider,
  DatePicker,
  Descriptions,
  Divider,
  Drawer,
  Dropdown,
  Empty,
  Form,
  FormModel,
  Icon,
  Input,
  InputNumber,
  Layout,
  List,
  LocaleProvider,
  Mentions,
  Menu,
  message,
  Modal,
  notification,
  Pagination,
  Popconfirm,
  Popover,
  Progress,
  Radio,
  Rate,
  Result,
  Row,
  Spin,
  Select,
  Skeleton,
  Slider,
  Statistic,
  Steps,
  Switch,
  Table,
  Transfer,
  Tree,
  TreeSelect,
  Tabs,
  Tag,
  TimePicker,
  Timeline,
  Tooltip,
  Upload,
  version
} from 'ant-design-vue'

Vue.use(Affix)
Vue.use(Alert)
Vue.use(Anchor)
Vue.use(AutoComplete)
Vue.use(Avatar)
Vue.use(Badge)
Vue.use(BackTop)
Vue.use(Base)
Vue.use(Breadcrumb)
Vue.use(Button)
Vue.use(Card)
Vue.use(Carousel)
Vue.use(Calendar)
Vue.use(Cascader)
Vue.use(Checkbox)
Vue.use(Col)
Vue.use(Collapse)
Vue.use(Comment)
Vue.use(ConfigProvider)
Vue.use(DatePicker)
Vue.use(Descriptions)
Vue.use(Divider)
Vue.use(Drawer)
Vue.use(Dropdown)
Vue.use(Empty)
Vue.use(Form)
Vue.use(FormModel)
Vue.use(Icon)
Vue.use(Input)
Vue.use(InputNumber)
Vue.use(Layout)
Vue.use(List)
Vue.use(LocaleProvider)
Vue.use(Mentions)
Vue.use(Menu)
Vue.use(message)
Vue.use(Modal)
Vue.use(notification)
Vue.use(Pagination)
Vue.use(Popconfirm)
Vue.use(Popover)
Vue.use(Progress)
Vue.use(Radio)
Vue.use(Rate)
Vue.use(Result)
Vue.use(Row)
Vue.use(Spin)
Vue.use(Select)
Vue.use(Skeleton)
Vue.use(Slider)
Vue.use(Statistic)
Vue.use(Steps)
Vue.use(Switch)
Vue.use(Table)
Vue.use(Transfer)
Vue.use(Tree)
Vue.use(TreeSelect)
Vue.use(Tabs)
Vue.use(Tag)
Vue.use(TimePicker)
Vue.use(Timeline)
Vue.use(Tooltip)
Vue.use(Upload)
Vue.use(version)

Vue.prototype.$confirm = Modal.confirm
Vue.prototype.$info = Modal.info
Vue.prototype.$success = Modal.success
Vue.prototype.$error = Modal.error
Vue.prototype.$warning = Modal.warning
Vue.prototype.$confirm = Modal.confirm
Vue.prototype.$destroyAll = Modal.destroyAll
Vue.prototype.$message = message
Vue.prototype.$notification = notification
