// ref: https://umijs.org/config/
const { NODE_ENV } = process.env;

const uglifyJSOptions =
  NODE_ENV === 'production'
    ? {
      uglifyOptions: {
        output: {
          comments: false, // remove comments
        },
        compress: {
          unused: true,
          dead_code: true, // big one--strip code that will never execute
          warnings: false, // good for prod apps so users can't peek behind curtain
          drop_debugger: true,
          conditionals: true,
          evaluate: true,
          drop_console: true, // strips console statements
          sequences: true,
          booleans: true,
        },
      },
      sourceMap: false,
      parallel: true,
    }
    : {};

// 解决跨域需要在webpack配置proxy代理
// umi将webpack配置保存在.umirc.js的配置文件中
// 本地发送请求http://localhost:8000
// 实际发送请求http://localhost:8094
const proxy =
  // umi dev NODE_ENV='development'需要配置
  // umi build NODE_ENV='production'不需要配置
  NODE_ENV === 'development'
    ? {
      '/api': {
        // target: 'http://localhost:8094',         // 开发环境
        // target: `http://yhtsit.sunline.cn:8094`, // 测试环境
        target: `http://yht.sunline.cn:8094`,       // 生产环境
        changeOrigin: true,
        // pathRewrite: { '^/api': '' },
      },
    }
    : {};

const chainWebpack = config => {
  console.log('pro', process.env.NODE_ENV)
  if (NODE_ENV === 'production') {
    config.merge({
      optimization: {
        minimize: true,
        splitChunks: {
          chunks: 'async',
          minSize: 30000,
          minChunks: 2,
          automaticNameDelimiter: '.',
          cacheGroups: {
            vendor: {
              name: 'vendors',
              test: /^.*node_modules[\\/](?!ag-grid-|d3-|dva|braft-editor|bizcharts|lodash|react-virtualized|rc-select|rc-drawer|rc-time-picker|rc-tree|rc-table|rc-calendar|antd).*$/,
              chunks: 'all',
              priority: 10,
            },
            virtualized: {
              name: 'virtualized',
              test: /[\\/]node_modules[\\/]react-virtualized/,
              chunks: 'all',
              priority: 10,
            },
            rcselect: {
              name: 'rc-select',
              test: /[\\/]node_modules[\\/]rc-select/,
              chunks: 'all',
              priority: 10,
            },
            rcdrawer: {
              name: 'rcdrawer',
              test: /[\\/]node_modules[\\/]rc-drawer/,
              chunks: 'all',
              priority: 10,
            },
            rctimepicker: {
              name: 'rctimepicker',
              test: /[\\/]node_modules[\\/]rc-time-picker/,
              chunks: 'all',
              priority: 10,
            },
            ag: {
              name: 'ag',
              test: /[\\/]node_modules[\\/]ag-grid-/,
              chunks: 'all',
              priority: 10,
            },
            antd: {
              name: 'antd',
              test: /[\\/]node_modules[\\/]antd[\\/]/,
              chunks: 'all',
              priority: 9,
            },
            dva: {
              name: 'dva',
              test: /[\\/]node_modules[\\/]dva/,
              chunks: 'all',
              priority: 10,
            },
            rctree: {
              name: 'rctree',
              test: /[\\/]node_modules[\\/]rc-tree/,
              chunks: 'all',
              priority: -1,
            },
            rccalendar: {
              name: 'rccalendar',
              test: /[\\/]node_modules[\\/]rc-calendar[\\/]/,
              chunks: 'all',
              priority: -1,
            },
            rctable: {
              name: 'rctable',
              test: /[\\/]node_modules[\\/]rc-table[\\/]es[\\/]/,
              chunks: 'all',
              priority: -1,
            },
            lodash: {
              name: 'lodash',
              test: /[\\/]node_modules[\\/]lodash[\\/]/,
              chunks: 'all',
              priority: -2,
            },
          },
        },
      },
    });
    //过滤掉momnet的那些不使用的国际化文件
    config
      .plugin('replace')
      .use(require('webpack').ContextReplacementPlugin)
      .tap(() => {
        return [/moment[/\\]locale$/, /zh-cn/];
      });
  }
  return config;
};
export default {
  define: {
    'process.env.apiUrl': 'http://yht.sunline.cn:8094', // 生产环境
  },
  hash: true,
  treeShaking: true,
  cssLoaderOptions: {
    localIdentName: '[local]',
  },
  chainWebpack,
  proxy,
  uglifyJSOptions,
  plugins: [
    // ref: https://umijs.org/plugin/umi-plugin-react.html
    [
      'umi-plugin-react',
      {
        antd: true,
        dva: true,
        dynamicImport: { webpackChunkName: true },
        title: 'agiletc-web',
        dll: true,
        routes: {
          exclude: [
            /models\//,
            /services\//,
            /model\.(t|j)sx?$/,
            /service\.(t|j)sx?$/,
            /components\//,
          ],
        },
      },
    ],
  ],
  disableRedirectHoist: true,
  routes: [
    {
      path: '/',
      component: '../layouts/index.js',
      routes: [
        {
          exact: true,
          path: '/',
          component: './landing/index.jsx',
        },
        {
          path: '/case/caseList/:productLineId',
          component: './casepage/index.js',
        },
        {
          path: '/caseManager/:productLineId/:caseId/:itemid/:iscore',
          component: './testTask/index.js',
        },
        {
          path: '/login',
          component: './landing/login.jsx',
        },
        {
          path: '/history/:caseId',
          component: './contrast/index.jsx',
        },
        {
          path: '/caseManager/historyContrast/:caseId1/:caseId2',
          component: './contrast/seeResult.js',
        },
        {
          path: '*',
          redirect: '/',
        },
      ],
    },
  ],
};
