import React from 'react';
import {
  Router as DefaultRouter,
  Route,
  Switch,
  StaticRouter,
} from 'react-router-dom';
import dynamic from 'umi/dynamic';
import renderRoutes from 'umi/lib/renderRoutes';
import history from '@@/history';
import { routerRedux, dynamic as _dvaDynamic } from 'dva';

const Router = routerRedux.ConnectedRouter;

const routes = [
  {
    path: '/',
    component: __IS_BROWSER
      ? _dvaDynamic({
          component: () =>
            import(/* webpackChunkName: "layouts__index" */ '../../layouts/index.js'),
        })
      : require('../../layouts/index.js').default,
    routes: [
      {
        exact: true,
        path: '/',
        component: __IS_BROWSER
          ? _dvaDynamic({
              component: () =>
                import(/* webpackChunkName: "p__landing__index" */ '../landing/index.jsx'),
            })
          : require('../landing/index.jsx').default,
        _title: 'agiletc-web',
        _title_default: 'agiletc-web',
      },
      {
        path: '/case/caseList/:productLineId',
        component: __IS_BROWSER
          ? _dvaDynamic({
              component: () =>
                import(/* webpackChunkName: "p__casepage__index" */ '../casepage/index.js'),
            })
          : require('../casepage/index.js').default,
        exact: true,
        _title: 'agiletc-web',
        _title_default: 'agiletc-web',
      },
      {
        path: '/caseManager/:productLineId/:caseId/:itemid/:iscore',
        component: __IS_BROWSER
          ? _dvaDynamic({
              component: () =>
                import(/* webpackChunkName: "p__testTask__index" */ '../testTask/index.js'),
            })
          : require('../testTask/index.js').default,
        exact: true,
        _title: 'agiletc-web',
        _title_default: 'agiletc-web',
      },
      {
        path: '/login',
        component: __IS_BROWSER
          ? _dvaDynamic({
              component: () =>
                import(/* webpackChunkName: "p__landing__login" */ '../landing/login.jsx'),
            })
          : require('../landing/login.jsx').default,
        exact: true,
        _title: 'agiletc-web',
        _title_default: 'agiletc-web',
      },
      {
        path: '/history/:caseId',
        component: __IS_BROWSER
          ? _dvaDynamic({
              component: () =>
                import(/* webpackChunkName: "p__contrast__index" */ '../contrast/index.jsx'),
            })
          : require('../contrast/index.jsx').default,
        exact: true,
        _title: 'agiletc-web',
        _title_default: 'agiletc-web',
      },
      {
        path: '/caseManager/historyContrast/:caseId1/:caseId2',
        component: __IS_BROWSER
          ? _dvaDynamic({
              component: () =>
                import(/* webpackChunkName: "p__contrast__seeResult" */ '../contrast/seeResult.js'),
            })
          : require('../contrast/seeResult.js').default,
        exact: true,
        _title: 'agiletc-web',
        _title_default: 'agiletc-web',
      },
      {
        path: '/*',
        redirect: '/',
        exact: true,
        _title: 'agiletc-web',
        _title_default: 'agiletc-web',
      },
      {
        component: () =>
          React.createElement(
            require('D:/King/Vue/AgileTC/case-server/src/main/resources/web/node_modules/umi-build-dev/lib/plugins/404/NotFound.js')
              .default,
            { pagesPath: 'src/pages', hasRoutesInConfig: true },
          ),
        _title: 'agiletc-web',
        _title_default: 'agiletc-web',
      },
    ],
    _title: 'agiletc-web',
    _title_default: 'agiletc-web',
  },
  {
    component: () =>
      React.createElement(
        require('D:/King/Vue/AgileTC/case-server/src/main/resources/web/node_modules/umi-build-dev/lib/plugins/404/NotFound.js')
          .default,
        { pagesPath: 'src/pages', hasRoutesInConfig: true },
      ),
    _title: 'agiletc-web',
    _title_default: 'agiletc-web',
  },
];
window.g_routes = routes;
const plugins = require('umi/_runtimePlugin');
plugins.applyForEach('patchRoutes', { initialValue: routes });

export { routes };

export default class RouterWrapper extends React.Component {
  unListen() {}

  constructor(props) {
    super(props);

    // route change handler
    function routeChangeHandler(location, action) {
      plugins.applyForEach('onRouteChange', {
        initialValue: {
          routes,
          location,
          action,
        },
      });
    }
    this.unListen = history.listen(routeChangeHandler);
    // dva 中 history.listen 会初始执行一次
    // 这里排除掉 dva 的场景，可以避免 onRouteChange 在启用 dva 后的初始加载时被多执行一次
    const isDva =
      history.listen
        .toString()
        .indexOf('callback(history.location, history.action)') > -1;
    if (!isDva) {
      routeChangeHandler(history.location);
    }
  }

  componentWillUnmount() {
    this.unListen();
  }

  render() {
    const props = this.props || {};
    return <Router history={history}>{renderRoutes(routes, props)}</Router>;
  }
}
