<div class="navbar navbar-default" id="navbar">
    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="icon-leaf"></i>
                    ACE后台管理系统
                </small>
            </a><!-- /.brand -->
        </div><!-- /.navbar-header -->

        <div class="navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">


                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="../static/avatars/user.jpg" alt="Jason's Photo"/>
                        <span class="user-info">
									<small>欢迎光临,</small>
                        ${user.name!}
								</span>

                        <i class="icon-caret-down"></i>
                    </a>

                    <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="#">
                                <i class="icon-cog"></i>
                                设置
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                <i class="icon-user"></i>
                                个人资料
                            </a>
                        </li>

                        <li class="divider"></li>

                        <li>
                            <a href="../logOut">
                                <i class="icon-off"></i>
                                退出
                            </a>
                        </li>
                    </ul>
                </li>
            </ul><!-- /.ace-nav -->
        </div><!-- /.navbar-header -->
    </div><!-- /.container -->
</div>

<a class="menu-toggler" id="menu-toggler" href="#">
    <span class="menu-text"></span>
</a>

<div class="sidebar" id="sidebar">
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'fixed')
        } catch (e) {
        }
    </script>

    <ul class="nav nav-list">
        <li class="active">
            <a href="index.html">
                <i class="icon-dashboard"></i>
                <span class="menu-text"> 控制台 </span>
            </a>
        </li>

        <li>
            <a onclick="menuOnclick('zSwagger','在线APIDocs','../swagger-ui.html')">
                <i class="icon-desktop"></i>
                <span class="menu-text"> 在线APIDocs </span>
            </a>
        </li>

        <li>
            <a onclick="menuOnclick('zDruid','服务器中心','../druid/index.html')">
                <i class="icon-desktop"></i>
                <span class="menu-text"> 服务器中心 </span>
            </a>
        </li>

        <li>
            <a onclick="menuOnclick('zCreateCode','代码生成器','../endSys/createCode')">
                <i class="icon-desktop"></i>
                <span class="menu-text"> 代码生成器 </span>
            </a>
        </li>

        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-tag"></i>
                <span class="menu-text"> 用户管理与维护 </span>

                <b class="arrow icon-angle-down"></b>
            </a>

            <ul class="submenu">

                <li>
                    <a onclick="menuOnclick('zUserIndex','用户列表','../endSys/userList')">
                        <i class="icon-text-width"></i>
                        <span class="menu-text"> 用户列表 </span>
                    </a>
                </li>

                <li>
                    <a onclick="menuOnclick('zAddUser','添加用户','../endSys/addUser')">
                        <i class="icon-text-width"></i>
                        <span class="menu-text"> 添加用户 </span>
                    </a>
                </li>


            </ul>
        </li>

    </ul><!-- /.nav-list -->
    <div class="sidebar-collapse" id="sidebar-collapse">
        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
    </div>

    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'collapsed')
        } catch (e) {
        }
    </script>
</div>
