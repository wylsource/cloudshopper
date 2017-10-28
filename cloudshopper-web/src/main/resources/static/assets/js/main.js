// const vm = new Vue({
//     el: '#app',
//     data: {
//         results: [
//             {title: '第一条新闻', abstract: '我是第一条新闻'},
//             {title: '接着是第二条', abstract: '我是第二条新闻'},
//             {title: '然后是第三条', abstract: '我是第三条新闻'},
//             {title: '我是最后一条了', abstract: '我是第四条新闻'}
//         ]
//     }
// });

//

const CloudShopperWebBaseUrl = "http://localhost:7900";
const CloudShopperUserBaseUrl = "http://localhost:7901";
const CloudShopperToolsBaseUrl = "http://localhost:7902";
const CloudShopperCommonBaseUrl = "http://localhost:7903";

/**
 * 拼接 url
 * @param pix 标识（根据其动态拼接要访问的url）
 * @param url 子路径（将其拼接在 baseUrl 之后，同时可以拼接参数）
 * @returns {string} 所需要的 url
 */
function buildUrl(pix, url) {
    var NiceUrl = '';
    if ('web' == pix){
        NiceUrl =  CloudShopperWebBaseUrl + url;
    }
    if ('user' == pix){
        NiceUrl =  CloudShopperUserBaseUrl + url;
    }
    if ('tools' == pix){
        NiceUrl =  CloudShopperToolsBaseUrl + url;
    }
    if ('common' == pix){
        NiceUrl =  CloudShopperCommonBaseUrl + url;
    }
    return NiceUrl;
}

const vm = new Vue ({
    el: '#testVue-Axios',
    data: {
        results: []
    },
    mounted () {
        this.getPosts('web', '/main/123456');
    },
    methods: {
        getPosts(pix, lastUrl) {
            let url = buildUrl(pix, lastUrl);
            axios.get(url).then((response) => {
                this.results = response.data;
            }).catch(error => {
                console.log(error);
            });
        }
    }
});