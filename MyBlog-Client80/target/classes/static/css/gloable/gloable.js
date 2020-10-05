layui.use(["jquery", "layer", "util"], function () {
    var n = layui.jquery,
        i = layui.layer,
        t = layui.util;
    t.fixbar();
    master.start(n)
});
var slider = 0,
    pathname = window.location.pathname.replace("Read", "Article"),
    master = {};
master.start = function (n) {
        function t() {
            var t = n("#nav a");
            n.each(t, function () {
                var t = n(this).attr("href");
                pathname.indexOf(t) != -1 && n(this).parent().addClass("current")
            })
        }
        n("#nav li").hover(function () {
            n(this).addClass("current")
        }, function () {
            var t = n(this).find("a").attr("href");
            pathname.indexOf(t) == -1 && n(this).removeClass("current")
        });
        t();
        n(".phone-menu").on("click", function () {
            n("#nav").toggle(500)
        });
        console.log(" 一个人到底多无聊");
        console.log(" 才会把 console 当成玩具");
        console.log(" 一个人究竟多堕落");
        console.log(" 才会把大好青春荒废在博客上");
        console.log("\n\n");
        console.log("follow me  %chttps://www.yanshisan.cn/", "color:#6bc30d");
        n(".blog-user img").hover(function () {
            var n = layer.tips("点击退出", ".blog-user", {
                tips: [3, "#009688"]
            })
        }, function () {
            layer.closeAll("tips")
        })
    },
    function (n, t) {
        typeof define == "function" && define.amd ? define(t) : typeof exports == "object" ? module.exports = t() : n.NProgress =
            t()
    }(this, function () {
        function f(n, t, i) {
            return n < t ? t : n > i ? i : n
        }

        function r(n) {
            return (-1 + n) * 100
        }

        function l(n, i, u) {
            var f;
            return f = t.positionUsing === "translate3d" ? {
                transform: "translate3d(" + r(n) + "%,0,0)"
            } : t.positionUsing === "translate" ? {
                transform: "translate(" + r(n) + "%,0)"
            } : {
                "margin-left": r(n) + "%"
            }, f.transition = "all " + i + "ms " + u, f
        }

        function o(n, t) {
            var i = typeof n == "string" ? n : u(n);
            return i.indexOf(" " + t + " ") >= 0
        }

        function s(n, t) {
            var i = u(n),
                r = i + t;
            o(i, t) || (n.className = r.substring(1))
        }

        function h(n, t) {
            var r = u(n),
                i;
            o(n, t) && (i = r.replace(" " + t + " ", " "), n.className = i.substring(1, i.length - 1))
        }

        function u(n) {
            return (" " + (n && n.className || "") + " ").replace(/\s+/gi, " ")
        }

        function c(n) {
            n && n.parentNode && n.parentNode.removeChild(n)
        }
        var n = {},
            t, e, i;
        return n.version = "0.2.0", t = n.settings = {
                minimum: .08,
                easing: "linear",
                positionUsing: "",
                speed: 200,
                trickle: !0,
                trickleSpeed: 200,
                showSpinner: !0,
                barSelector: '[role="bar"]',
                spinnerSelector: '[role="spinner"]',
                parent: "body",
                template: '<div class="bar" role="bar"><div class="peg"><\/div><\/div><div class="spinner" role="spinner"><div class="spinner-icon"><\/div><\/div>'
            }, n.configure = function (n) {
                var i, r;
                for (i in n) r = n[i], r !== undefined && n.hasOwnProperty(i) && (t[i] = r);
                return this
            }, n.status = null, n.set = function (r) {
                var s = n.isStarted();
                r = f(r, t.minimum, 1);
                n.status = r === 1 ? null : r;
                var u = n.render(!s),
                    h = u.querySelector(t.barSelector),
                    o = t.speed,
                    c = t.easing;
                return u.offsetWidth, e(function (f) {
                    t.positionUsing === "" && (t.positionUsing = n.getPositioningCSS());
                    i(h, l(r, o, c));
                    r === 1 ? (i(u, {
                        transition: "none",
                        opacity: 1
                    }), u.offsetWidth, setTimeout(function () {
                        i(u, {
                            transition: "all " + o + "ms linear",
                            opacity: 0
                        });
                        setTimeout(function () {
                            n.remove();
                            f()
                        }, o)
                    }, o)) : setTimeout(f, o)
                }), this
            }, n.isStarted = function () {
                return typeof n.status == "number"
            }, n.start = function () {
                n.status || n.set(0);
                var i = function () {
                    setTimeout(function () {
                        n.status && (n.trickle(), i())
                    }, t.trickleSpeed)
                };
                return t.trickle && i(), this
            }, n.done = function (t) {
                return !t && !n.status ? this : n.inc(.3 + .5 * Math.random()).set(1)
            }, n.inc = function (t) {
                var i = n.status;
                return i ? i > 1 ? void 0 : (typeof t != "number" && (t = i >= 0 && i < .2 ? .1 : i >= .2 && i < .5 ?
                        .04 : i >= .5 && i < .8 ? .02 : i >= .8 && i < .99 ? .005 : 0), i = f(i + t, 0, .994),
                    n.set(i)) : n.start()
            }, n.trickle = function () {
                return n.inc()
            },
            function () {
                var i = 0,
                    t = 0;
                n.promise = function (r) {
                    return !r || r.state() === "resolved" ? this : (t === 0 && n.start(), i++, t++, r.always(
                        function () {
                            t--;
                            t === 0 ? (i = 0, n.done()) : n.set((i - t) / i)
                        }), this)
                }
            }(), n.render = function (u) {
                var f;
                if (n.isRendered()) return document.getElementById("nprogress");
                s(document.documentElement, "nprogress-busy");
                f = document.createElement("div");
                f.id = "nprogress";
                f.innerHTML = t.template;
                var h = f.querySelector(t.barSelector),
                    l = u ? "-100" : r(n.status || 0),
                    e = document.querySelector(t.parent),
                    o;
                return i(h, {
                        transition: "all 0 linear",
                        transform: "translate3d(" + l + "%,0,0)"
                    }), t.showSpinner || (o = f.querySelector(t.spinnerSelector), o && c(o)), e != document.body &&
                    s(e, "nprogress-custom-parent"), e.appendChild(f), f
            }, n.remove = function () {
                h(document.documentElement, "nprogress-busy");
                h(document.querySelector(t.parent), "nprogress-custom-parent");
                var n = document.getElementById("nprogress");
                n && c(n)
            }, n.isRendered = function () {
                return !!document.getElementById("nprogress")
            }, n.getPositioningCSS = function () {
                var n = document.body.style,
                    t = "WebkitTransform" in n ? "Webkit" : "MozTransform" in n ? "Moz" : "msTransform" in n ? "ms" :
                    "OTransform" in n ? "O" : "";
                return t + "Perspective" in n ? "translate3d" : t + "Transform" in n ? "translate" : "margin"
            }, e = function () {
                function t() {
                    var i = n.shift();
                    i && i(t)
                }
                var n = [];
                return function (i) {
                    n.push(i);
                    n.length == 1 && t()
                }
            }(), i = function () {
                function r(n) {
                    return n.replace(/^-ms-/, "ms-").replace(/-([\da-z])/gi, function (n, t) {
                        return t.toUpperCase()
                    })
                }

                function u(t) {
                    var u = document.body.style,
                        i, f, r;
                    if (t in u) return t;
                    for (i = n.length, f = t.charAt(0).toUpperCase() + t.slice(1); i--;)
                        if (r = n[i] + f, r in u) return r;
                    return t
                }

                function f(n) {
                    return n = r(n), t[n] || (t[n] = u(n))
                }

                function i(n, t, i) {
                    t = f(t);
                    n.style[t] = i
                }
                var n = ["Webkit", "O", "Moz", "ms"],
                    t = {};
                return function (n, t) {
                    var u = arguments,
                        r, f;
                    if (u.length == 2)
                        for (r in t) f = t[r], f !== undefined && t.hasOwnProperty(r) && i(n, r, f);
                    else i(n, u[1], u[2])
                }
            }(), n
    })