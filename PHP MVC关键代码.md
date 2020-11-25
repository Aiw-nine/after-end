### PHP MVC关键代码（若需要PDF打印版，[请点我进行下载](https://cowtransfer.com/s/08cb29a47a5f4b)）

------

##### 1、定义路由：web.php（位置：laravel\routes\web.php）

```php
<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

// Route::get('/', function () {
//     return view('welcome');
// });

Route::get('news/index','NewsController@index');  // 首页路由
Route::get('news/show','NewsController@show');  // 详情页路由
```

> 说明：3-16行代码均是注释代码，不用管

------

##### 2、定义模型：News.php（位置：laravel\app\News.php）

```php
<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class News extends Model
{
    // 指定数据库表名
    protected $table = 'news';

    // 关闭自动维护时间戳
    public $timestamps = false;
}
```

------

##### 3、定义控制器：NewsController.php（位置：laravel\app\Http\Controllers\NewsController.php）

```php
<?php

namespace App\Http\Controllers;
use App\News;  // 导入模型命名空间

use Illuminate\Http\Request;

class NewsController extends Controller
{
    public function index()
    {
        $data = News::paginate(2);  // 利用模型分页查询，每页显示2条数据
        return view('news')->with(compact('data'));  // 返回视图，并传递数据
        // 变法1：return view('news',['data'=>$data]);
        // 变法2：return view('news',compact('data'));
    }

    public function show(Request $request)
    {
        $id = $request->get('id');  // 获取请求中的id数据
        // 变法1：$id = $request->input('id');
        $news = News::where('id',$id)->first();  // 利用模型查询单个对象
        // 变法1：$news = News::find($id);
        return view('show')->with(compact('news'));  // 返回视图，并传递数据
        // 变法1：return view('show',['news'=>$news]);
        // 变法2：return view('show',compact('news'));
    }
}
```

> 说明：考试时灵活选择变法

------

##### 4.1、定义视图：news.blade.php（位置：laravel\resources\views\news.blade.php）

```php
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>新闻发布系统</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="box">
	<div class="top">
		<div class="title">新闻发布系统</div>
		<div class="nav">
			<a href="#">发表新闻</a>
		</div>
	</div>
	<div class="main">
		<table class="news-list">	    
			<tr><th>新闻标题</th><th width="250">发布时间</th></tr>						
			@foreach($data as $v)
				<tr>
					<td class="news-title">
						<a href="/news/show?id={{ $v->id }}">{{ $v->title }}</a>
					</td>
					<td class="center">{{ $v->addtime }}</td>					
				</tr>
			@endforeach
		</table>
		<div class="center-block">{!! $data->links() !!}</div>	
    	<!--变法1：可将{!! $data->links() !!}改成{{ $data->links() }}-->
	</div>		
</div>
</body>
</html>
```

------

##### 4.2、定义视图：show.blade.php（位置：laravel\resources\views\show.blade.php）

```php
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>新闻发布系统</title>
<style>
	/*此处样式省略*/
</style>
</head>
<body>
<div class="box">
	<div class="top">
		<div class="title">新闻发布系统</div>
		<div class="nav">
			<a href="/news/index">返回列表</a>
		</div>
	</div>
	<div class="main">
		<!-- 新闻标题 -->
		<div class="news-title">{{ $news->title }}</div>
		<!-- 发布时间 -->
		<div class="news-time">{{ $news->addtime }}</div>
		<!-- 新闻内容 -->
		<div class="news-content">{{ $news->content }}</div> 
	</div>
</div>
</body>
</html>
```

