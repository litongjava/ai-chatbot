"use strict";
(self.webpackChunk_N_E = self.webpackChunk_N_E || []).push([
  [9119],
  {
    59119: function (e, t, a) {
      a.d(t, {
        FB: function () {
          return eG;
        },
        ZP: function () {
          return eU;
        },
        wS: function () {
          return ez;
        },
      });
      var n,
        i,
        r,
        s,
        o = a(22830),
        c = a(35250),
        l = a(88798),
        d = a(21739),
        u = a(32542),
        p = a(77010),
        f = a(70079),
        m = a(32877),
        g = a(37469),
        h = a(78931),
        x = a(61888),
        v = a(70671),
        b = a(94968),
        y = a(95137),
        k = a(21722),
        w = a(39324),
        j = a(71209),
        M = a(38104),
        C = a(12155),
        _ = a(60554),
        N = a(1454),
        T = a(32004),
        S = a(79579),
        P = a(89368),
        Z = a(1821);
      function B() {
        var e = (0, y.Go)(),
          t = (0, _.useRouter)(),
          a = (0, v.Z)(),
          n = (0, o._)((0, f.useState)(), 2),
          i = n[0],
          r = n[1],
          s = null !== e;
        if (
          ((0, f.useEffect)(
            function () {
              s || r(void 0);
            },
            [s]
          ),
          !s)
        )
          return null;
        var l = (0, c.jsx)("span", { className: "font-medium", children: e.ownerEmail }),
          d = e.hasActiveRequest || "success" === i;
        return (0, c.jsx)(P.Z, {
          isOpen: !0,
          onClose: x.noop,
          type: "warning",
          size: "custom",
          className: "max-w-3xl",
          title: (0, c.jsxs)("div", {
            className: "flex flex-col",
            children: [
              (0, c.jsx)("div", {
                className: "text-lg",
                children: (0, c.jsx)(
                  T.Z,
                  (0, j._)((0, w._)({}, D.title), { values: { workspaceName: e.accountName } })
                ),
              }),
              (0, c.jsx)("div", {
                className: "text-sm font-normal",
                children: (0, c.jsx)(T.Z, (0, w._)({}, D.subtitle)),
              }),
            ],
          }),
          icon: N.UIZ,
          primaryButton: (0, c.jsx)(S.ZP.Button, {
            onClick: (0, k._)(function () {
              return (0, M.Jh)(this, function (t) {
                switch (t.label) {
                  case 0:
                    r("requesting"), (t.label = 1);
                  case 1:
                    return t.trys.push([1, 3, , 4]), [4, y.ZP.requestWorkspaceAccess(e.accountId)];
                  case 2:
                    return t.sent().success && r("success"), [3, 4];
                  case 3:
                    return t.sent(), r("error"), [3, 4];
                  case 4:
                    return [2];
                }
              });
            }),
            color: "primary",
            title: a.formatMessage(D.requestAccessButton),
            disabled: d,
          }),
          secondaryButton: (0, c.jsx)(S.ZP.Button, {
            onClick: (0, k._)(function () {
              var e;
              return (0, M.Jh)(this, function (a) {
                switch (a.label) {
                  case 0:
                    return [
                      4,
                      (0, C.signOut)({
                        redirect: !1,
                        callbackUrl: "/auth/login?next=".concat(encodeURIComponent(t.asPath)),
                      }),
                    ];
                  case 1:
                    return (e = a.sent()), t.push(e.url), [2];
                }
              });
            }),
            color: "neutral",
            title: a.formatMessage(D.signOutButton),
          }),
          children: (0, c.jsxs)("div", {
            className: "flex flex-col space-y-4",
            children: [
              (0, c.jsx)("div", {
                children: (0, c.jsx)(
                  T.Z,
                  (0, j._)((0, w._)({}, D.emailBelongsToWorkspace), {
                    values: { email: (0, c.jsx)("span", { className: "font-medium", children: e.userEmail }) },
                  })
                ),
              }),
              (0, c.jsx)("div", {
                children: d
                  ? (0, c.jsx)(T.Z, (0, j._)((0, w._)({}, D.activeRequestMessage), { values: { email: l } }))
                  : "requesting" === i
                  ? (0, c.jsx)(Z.Z, {})
                  : "error" === i
                  ? (0, c.jsx)(T.Z, (0, j._)((0, w._)({}, D.contactWorkspaceAdminEmail), { values: { email: l } }))
                  : null,
              }),
            ],
          }),
        });
      }
      var D = {
          title: {
            id: "RequestWorkspaceAccessModal.title",
            defaultMessage: "Request access to {workspaceName}",
            description: "Title for request access modal for a workspace",
          },
          subtitle: {
            id: "RequestWorkspaceAccessModal.subtitle",
            defaultMessage: "ChatGPT Enterprise has been enabled in your workspace",
            description: "Subtitle for request access modal mentioning ChatGPT Enterprise",
          },
          emailBelongsToWorkspace: {
            id: "RequestWorkspaceAccessModal.emailBelongsToWorkspace",
            defaultMessage: "{email} belongs to a ChatGPT Enterprise plan but currently has no access.",
            description: "Message shown telling the user their email is part of an enterprise workspace.",
          },
          requestWorkspaceAccessMessage: {
            id: "RequestWorkspaceAccessModal.requestWorkspaceAccessMessage",
            defaultMessage: "You may request access to the workspace account.",
            description: "Message telling the user to request access to the workspace.",
          },
          requestedWorkspaceAccessMessage: {
            id: "RequestWorkspaceAccessModal.requestedWorkspaceAccessMessage",
            defaultMessage:
              "Successfully requested access to the workspace account. Your workspace administrator at {email} may approve the request.",
            description: "Message telling the user they have requested access to the workspace.",
          },
          contactWorkspaceAdminEmail: {
            id: "RequestWorkspaceAccessModal.contactWorkspaceAdminEmail",
            defaultMessage:
              "Could not request access. Contact your workspace administrator at {email} to request access to a new workspace account.",
            description: "Message telling the user who to contact to create a new account for the workspace.",
          },
          signOutButton: {
            id: "RequestWorkspaceAccessModal.signOutButton",
            defaultMessage: "Sign Out",
            description: "Label for sign out button on modal",
          },
          requestAccessButton: {
            id: "RequestWorkspaceAccessModal.requestAccessButton",
            defaultMessage: "Request access",
            description: "Label for request access button on modal",
          },
          activeRequestMessage: {
            id: "RequestWorkspaceAccessModal.activeRequestMessage",
            defaultMessage:
              "You have a pending invite request for this workspace. Contact your workspace administrator at {email} to approve your request.",
            description: "Message telling the user they have an active request for the workspace.",
          },
        },
        A = a(75641),
        W = a(88809),
        I = a(25260),
        E = a(62509),
        V = a(19841),
        L = a(91530),
        q = a.n(L),
        O = a(19579),
        R = a.n(O),
        G = a(6038),
        z = a(32367),
        U = a(52696);
      function H(e) {
        var t = e.workspace,
          a = (0, E.kP)().session,
          n = (0, h.ec)(function (e) {
            return e.currentWorkspace;
          }),
          i = (null == n ? void 0 : n.id) === t.id,
          r = (0, o._)((0, f.useState)(!1), 2),
          s = r[0],
          l = r[1],
          d = (0, z.Z)().onEnableHistory,
          u = (0, f.useCallback)(
            (0, k._)(function () {
              return (0, M.Jh)(this, function (e) {
                return l(!0), h.w_.setCurrentWorkspace(t), d(), (0, W.M)(), [2];
              });
            }),
            [t, d]
          ),
          p = (0, U.GA)(t),
          m = (0, c.jsx)("div", { className: "flex items-center justify-center", children: (0, c.jsx)(G.B0, {}) });
        if (t.structure === A.CZ.PERSONAL) {
          if (!(null == a ? void 0 : a.user)) return null;
          m = (0, c.jsx)("div", {
            className: "flex items-center justify-center",
            children: (0, c.jsx)(R(), {
              alt: "Profile",
              src: a.user.picture,
              width: 38,
              height: 38,
              className: "flex items-center justify-center rounded-sm",
            }),
          });
        }
        return (0, c.jsxs)(i ? "div" : "button", {
          onClick: i ? q() : u,
          className: (0, V.default)({
            "flex w-full items-center gap-2 rounded-lg border border-gray-100 bg-gray-50 p-4 hover:bg-gray-100 focus:bg-gray-100 dark:border-gray-700 dark:bg-gray-800 dark:hover:bg-gray-700 dark:focus:bg-gray-700":
              !0,
            "bg-gray-50 dark:bg-gray-800": i,
          }),
          children: [
            (0, c.jsxs)("div", {
              className: "flex w-full items-center gap-4",
              children: [m, (0, c.jsx)("div", { className: "inline align-top font-medium", children: p })],
            }),
            (0, c.jsx)("div", {
              className: "flex h-full items-center p-1",
              children: s
                ? (0, c.jsx)(Z.Z, {})
                : i
                ? (0, c.jsx)(I.Z, { className: "icon-lg" })
                : (0, c.jsx)(N.Tfp, { className: "icon-lg my-auto" }),
            }),
          ],
        });
      }
      function F(e) {
        var t = e.data.map(function (e) {
          return (0, c.jsx)(H, { workspace: e }, e.id);
        });
        return (0, c.jsx)("div", { className: "flex w-full flex-col gap-2", children: t });
      }
      function Q() {
        var e,
          t,
          a = (0, U._O)(),
          n = (0, E.kP)().session,
          i =
            null !== (t = null == n ? void 0 : null === (e = n.user) || void 0 === e ? void 0 : e.email) && void 0 !== t
              ? t
              : "";
        if (0 === a.length) return null;
        var r = a.filter(function (e) {
          return e.structure === A.CZ.WORKSPACE;
        });
        return (0, c.jsx)(P.Z, {
          isOpen: !0,
          onClose: q(),
          type: "success",
          size: "normal",
          title: (0, c.jsxs)("div", {
            className: "flex flex-col",
            children: [
              (0, c.jsx)(T.Z, (0, w._)({}, X.workspaceSwitcherTitle)),
              (0, c.jsx)("span", { className: "mt-0.5 text-sm text-gray-700 dark:text-gray-400", children: i }),
            ],
          }),
          children: (0, c.jsxs)("div", {
            className: "flex w-full flex-col items-center justify-between",
            children: [
              (0, c.jsx)(F, { data: a }),
              (0, c.jsx)("span", {
                className: "mt-4 text-sm text-gray-700 dark:text-gray-400",
                children: (0, c.jsx)(
                  T.Z,
                  (0, j._)((0, w._)({}, X.workspaceSwitcherDisclaimer), {
                    values: {
                      workspaces: (0, c.jsx)("span", {
                        className: "contents font-bold",
                        children: (0, c.jsx)(b.yX, {
                          value: r.map(function (e) {
                            return e.name;
                          }),
                        }),
                      }),
                      numWorkspaces: r.length,
                    },
                  })
                ),
              }),
            ],
          }),
        });
      }
      var X = (0, b.vU)({
          workspaceSwitcherTitle: {
            id: "workspaceSwitcher.title",
            defaultMessage: "Select a workspace",
            description: "title for account switcher modal",
          },
          workspaceSwitcherDisclaimer: {
            id: "workspaceSwitcher.disclaimer",
            defaultMessage:
              "You've been added to the {workspaces} {numWorkspaces, plural, one {workspace} other {workspaces}}. You can switch between workspaces at any time.",
            description: "disclaimer for account switcher modal",
          },
        }),
        Y = a(46020),
        J = a(80474),
        K = a(37952),
        $ = a(16920),
        ee = a(67273);
      function et(e) {
        var t = e.children;
        return (0, c.jsxs)(J.zt, {
          children: [
            (0, c.jsx)(J.fC, {
              className:
                "radix-state-closed:animate-hide radix-state-open:animate-slideIn grid grid-cols-[auto_max-content] items-center gap-x-4 rounded-lg bg-white p-4 shadow-xs [grid-template-areas:_'title_action'_'description_action'] dark:bg-gray-950 sm:max-w-2xl",
              open: !0,
              children: t,
            }),
            (0, c.jsx)(J.l_, {
              className: "fixed bottom-0 right-0 z-50 m-0 flex max-w-[100vw] list-none flex-col gap-4 p-6 outline-none",
            }),
          ],
        });
      }
      function ea(e) {
        var t = e.onClose,
          a = e.ageVerificationDeadline;
        return (
          (0, f.useEffect)(function () {
            $.m9.logEvent("chatgpt_compliance_age_verification_seen");
          }, []),
          (0, c.jsxs)(et, {
            children: [
              (0, c.jsx)(J.Dx, {
                className: "text-sm font-medium [grid-area:_title]",
                children: (0, c.jsx)(
                  T.Z,
                  (0, j._)((0, w._)({}, en.ageVerificationTitle), {
                    values: {
                      deadline: null != a ? Math.floor(a / 60 / 60 / 24) : 0,
                      learnMoreLink: function (e) {
                        return (0, c.jsx)("a", {
                          href: "https://github.com/litongjava/ai-chatbot",
                          target: "_blank",
                          rel: "noreferrer",
                          className: "cursor-pointer font-normal underline",
                          children: e,
                        });
                      },
                    },
                  })
                ),
              }),
              (0, c.jsx)(J.aU, {
                altText: "Dismiss notification",
                asChild: !0,
                children: (0, c.jsx)(ee.z, {
                  color: "primary",
                  size: "small",
                  onClick: function () {
                    $.m9.logEvent("chatgpt_compliance_age_verification_clicked"),
                      K.b.setCookie(K.c.AgeVerification, "true", { maxAge: 86400, path: "/" }),
                      t(),
                      Y.vm.openModal(Y.B.AgeVerificationInterstitial);
                  },
                  children: (0, c.jsx)(T.Z, (0, w._)({}, en.startVerification)),
                }),
              }),
              (0, c.jsx)(J.x8, {}),
            ],
          })
        );
      }
      var en = (0, b.vU)({
          ageVerificationTitle: {
            id: "ageVerificationBanner.title-v1",
            defaultMessage:
              "Please give me a star.",
            description: "Explanation of why ChatGPT needs to verify age",
          },
          ageVerificationDescription: {
            id: "ageVerificationBanner.description",
            defaultMessage: "<learnMoreLink>Learn more</learnMoreLink>",
            description: "Link to learn more about why ChatGPT needs to verify age",
          },
          learnMoreLink: {
            id: "ageVerificationBanner.learnMoreLink",
            defaultMessage: "Learn more",
            description: "Link to learn more about why ChatGPT needs to verify age",
          },
          dismiss: {
            id: "ageVerificationBanner.dismiss",
            defaultMessage: "Dismiss",
            description: "Dismiss/close age verification ui Banner",
          },
          startVerification: {
            id: "ageVerificationBanner.startVerification",
            defaultMessage: "Give me a star",
            description: "Start age verification process button",
          },
        }),
        ei = a(4337),
        er = a(21389),
        es = a(12346);
      function eo() {
        var e = (0, ei._)(["underline font-normal"]);
        return (
          (eo = function () {
            return e;
          }),
          e
        );
      }
      function ec(e) {
        var t = e.onClose,
          a = (0, es.Fr)().openSettings;
        return (0, c.jsxs)(et, {
          children: [
            (0, c.jsx)(J.Dx, {
              className: "text-sm font-medium [grid-area:_title]",
              children: (0, c.jsx)(
                T.Z,
                (0, j._)((0, w._)({}, ed.cookieConsentBannerTitle), {
                  values: {
                    privacyPolicyLink: function (e) {
                      return (0, c.jsx)(el, {
                        href: "https://openai.com/policies/privacy-policy",
                        target: "_blank",
                        rel: "noreferrer",
                        children: e,
                      });
                    },
                    learnMoreLink: function (e) {
                      return (0, c.jsx)(el, {
                        href: "https://help.openai.com/articles/8077698-how-do-i-use-chatgpt-browse-with-bing-to-search-the-web",
                        target: "_blank",
                        rel: "noreferrer",
                        children: e,
                      });
                    },
                    settingsPanel: function (e) {
                      return (0, c.jsx)(el, {
                        $as: "button",
                        onClick: function () {
                          a(es.u5.DataControls);
                        },
                        children: e,
                      });
                    },
                  },
                })
              ),
            }),
            (0, c.jsxs)("div", {
              className: "flex gap-3",
              children: [
                (0, c.jsx)(ee.z, {
                  color: "neutral",
                  size: "small",
                  onClick: function () {
                    t();
                  },
                  children: (0, c.jsx)(T.Z, (0, w._)({}, ed.reject)),
                }),
                (0, c.jsx)(ee.z, {
                  color: "primary",
                  size: "small",
                  onClick: function () {
                    t();
                  },
                  children: (0, c.jsx)(T.Z, (0, w._)({}, ed.accept)),
                }),
              ],
            }),
            (0, c.jsx)(J.x8, {}),
          ],
        });
      }
      var el = er.Z.a(eo()),
        ed = (0, b.vU)({
          cookieConsentBannerTitle: {
            id: "CookieConsentBanner.title",
            defaultMessage:
              "We use cookies to provide, improve, and protect our services. Visit our <privacyPolicyLink>privacy policy</privacyPolicyLink> to learn more. You can manage your cookie preferences in your <settingsPanel>settings panel</settingsPanel>. <learnMoreLink>Learn more</learnMoreLink>.",
            description: "Explanation of why ChatGPT needs to verify age",
          },
          reject: {
            id: "CookieConsentBanner.reject",
            defaultMessage: "Reject",
            description: "Reject analytics cookies button",
          },
          accept: {
            id: "CookieConsentBanner.accept",
            defaultMessage: "Accept",
            description: "Consent to analytics cookies button",
          },
        }),
        eu = a(77311),
        ep = a(6948),
        ef = a(88327),
        em = "oai/apps/hasSeenOnboarding";
      function eg(e, t) {
        return e === r.Workspace ? "".concat(em, "/").concat(e, "/").concat(t) : "".concat(em, "/").concat(e);
      }
      ((n = r || (r = {})).Personal = "chat"), (n.Workspace = "workspace");
      var eh = function (e, t) {
        var a = (0, f.useCallback)(
            function () {
              ep.m.setItem(
                eg(e, t),
                new Date().toLocaleDateString("en-CA", { year: "numeric", month: "2-digit", day: "2-digit" })
              );
            },
            [e, t]
          ),
          n = (0, o._)((0, f.useState)(null), 2),
          i = n[0],
          s = n[1];
        (0, f.useEffect)(
          function () {
            var a = ep.m.getItem("".concat(em, "/").concat(e));
            a || e !== r.Workspace || (a = ep.m.getItem(eg(e, t))), s(!!a && a);
          },
          [e, t]
        );
        var c = (0, f.useCallback)(
          function () {
            return i ? new Date(!0 === i ? "2022-12-14" : i) : new Date();
          },
          [i]
        );
        return (0, f.useMemo)(
          function () {
            return { setHasSeenOnboarding: a, getHasSeenOnboardingDate: c };
          },
          [c, a]
        );
      };
      function ex(e) {
        var t = e.onClose,
          a = e.scope,
          n = eh(a, (0, h.ec)(h.F_.workspaceId)).setHasSeenOnboarding,
          i = (0, f.useCallback)(
            function () {
              t(!0), n();
            },
            [t, n]
          );
        return a === r.Personal ? (0, c.jsx)(eb, { onSubmit: i }) : (0, c.jsx)(ey, { onSubmit: i });
      }
      var ev = function (e) {
          var t = e.icon,
            a = e.title,
            n = e.body;
          return (0, c.jsxs)("div", {
            children: [
              (0, c.jsxs)("div", {
                className: "flex flex-row items-center gap-1.5",
                children: [
                  (0, c.jsx)("div", { children: t }),
                  (0, c.jsx)("div", { className: "font-medium text-token-text-primary", children: a }),
                ],
              }),
              (0, c.jsx)("div", { className: "text-sm text-token-text-secondary", children: n }),
            ],
          });
        },
        eb = function (e) {
          var t = e.onSubmit,
            a = (0, v.Z)();
          return (0, c.jsxs)("div", {
            className: "flex flex-col gap-6",
            children: [
              (0, c.jsx)(ev, {
                icon: (0, c.jsx)(ef.wP, { isSolid: !0, className: "h-5 w-5 text-green-600" }),
                title: (0, c.jsx)(T.Z, (0, w._)({}, ek.askAway)),
                body: (0, c.jsx)(T.Z, (0, w._)({}, ek.askAwayBody)),
              }),
              (0, c.jsx)(ev, {
                icon: (0, c.jsx)(ef.NJ, { className: "text-brand-purple" }),
                title: (0, c.jsx)(T.Z, (0, w._)({}, ek.warning)),
                body: (0, c.jsx)(
                  T.Z,
                  (0, j._)((0, w._)({}, ek.warningBody), {
                    values: {
                      article: function (e) {
                        return (0, c.jsx)("a", {
                          href: "https://help.openai.com/en/articles/7039943-data-usage-for-consumer-services-faq",
                          target: "_blank",
                          className: "underline",
                          rel: "noopener noreferrer",
                          children: e,
                        });
                      },
                    },
                  })
                ),
              }),
              (0, c.jsx)(ev, {
                icon: (0, c.jsx)(ef.CJ, { className: "text-orange-300" }),
                title: (0, c.jsx)(T.Z, (0, w._)({}, ek.accuracy)),
                body: (0, c.jsx)(T.Z, (0, w._)({}, ek.accuracyBody)),
              }),
              (0, c.jsx)("div", {
                className: "flex flex-row justify-end",
                children: (0, c.jsx)(S.mH, {
                  title: a.formatMessage(ek.gettingStartedButton),
                  onClick: t,
                  color: "primary",
                }),
              }),
            ],
          });
        },
        ey = function (e) {
          var t = e.onSubmit,
            a = (0, v.Z)(),
            n = (0, h.ec)(function (e) {
              return e.currentWorkspace;
            }),
            i = null == n ? void 0 : n.name;
          return (0, c.jsxs)("div", {
            className: "flex flex-col gap-3",
            children: [
              (0, c.jsxs)("div", {
                children: [
                  (0, c.jsx)("div", {
                    className: "font-medium text-token-text-primary",
                    children:
                      null != i
                        ? (0, c.jsx)(T.Z, (0, w._)({ values: { workspaceName: i } }, ek.workspaceWelcome))
                        : (0, c.jsx)(T.Z, (0, w._)({}, ek.workspaceWelcomeNoName)),
                  }),
                  (0, c.jsx)("div", {
                    className: "text-sm text-token-text-secondary",
                    children: (0, c.jsx)(T.Z, (0, w._)({}, ek.workspaceWelcomeBody)),
                  }),
                ],
              }),
              (0, c.jsx)(ev, {
                icon: (0, c.jsx)(eu.Z, { className: "icon-md text-brand-purple" }),
                title: (0, c.jsx)(T.Z, (0, w._)({}, ek.workUse)),
                body: (0, c.jsx)(T.Z, (0, w._)({}, ek.workUseBody)),
              }),
              (0, c.jsx)(ev, {
                icon: (0, c.jsx)(ef.wP, { isSolid: !0, className: "h-5 w-5 text-green-600" }),
                title: (0, c.jsx)(T.Z, (0, w._)({}, ek.askAway)),
                body: (0, c.jsx)(T.Z, (0, w._)({}, ek.askAwayBody)),
              }),
              (0, c.jsx)(ev, {
                icon: (0, c.jsx)(ef.CJ, { className: "text-orange-300" }),
                title: (0, c.jsx)(T.Z, (0, w._)({}, ek.accuracy)),
                body: (0, c.jsx)(T.Z, (0, w._)({}, ek.accuracyBody)),
              }),
              (0, c.jsx)("div", {
                className: "flex flex-row justify-end",
                children: (0, c.jsx)(S.mH, {
                  title: a.formatMessage(ek.gettingStartedButton),
                  onClick: t,
                  color: "primary",
                }),
              }),
            ],
          });
        },
        ek = (0, b.vU)({
          askAway: {
            id: "onboarding.askAway",
            defaultMessage: "Ask away",
            description: "Title for the tip about what ChatGPT can do",
          },
          askAwayBody: {
            id: "onboarding.askAwayBody",
            defaultMessage:
              "ChatGPT can answer questions, help you learn, write code, brainstorm together, and much more.",
            description: "Body copy for the tip about what ChatGPT can do",
          },
          warning: {
            id: "onboarding.warning",
            defaultMessage: "Don’t share sensitive info",
            description: "Title for the warning about ChatGPT traning",
          },
          warningBody: {
            id: "onboarding.warningBody",
            defaultMessage:
              "Chat history may be reviewed or used to improve our services. Learn more about your choices in our <article>Help Center</article>.",
            description: "Body copy for the warning about ChatGPT traning",
          },
          accuracy: {
            id: "onboarding.accuracy",
            defaultMessage: "Check your facts",
            description: "Title for the warning about ChatGPT inaccuracy",
          },
          accuracyBody: {
            id: "onboarding.accuracyBody",
            defaultMessage:
              "While we have safeguards, ChatGPT may give you inaccurate information. It’s not intended to give advice.",
            description: "Body copy for the warning about ChatGPT inaccuracy",
          },
          gettingStartedButton: {
            id: "onboarding.gettingStartedButton",
            defaultMessage: "Okay, let’s go",
            description: "Button to accept the getting started modal",
          },
          workspaceWelcome: {
            id: "onboarding.workspaceWelcome",
            defaultMessage: "Welcome to the {workspaceName} Workspace",
            description: "Introduction welcome for workspace onboarding",
          },
          workspaceWelcomeNoName: {
            id: "onboarding.workspaceWelcomeNoName",
            defaultMessage: "Welcome to the your Workspace",
            description: "Introduction welcome for workspace onboarding when no Workspace name is available",
          },
          workspaceWelcomeBody: {
            id: "onboarding.workspaceWelcomeBody",
            defaultMessage: "Here you can use our latest models, with more capabilities, and fewer limits.",
            description: "Introduction welcome body for workspace onboarding",
          },
          workUse: {
            id: "onboarding.workUse",
            defaultMessage: "Made for use at work",
            description: "Title for the warning about ChatGPT business workspace use",
          },
          workUseBody: {
            id: "onboarding.workUseBody",
            defaultMessage: "By default, chats in this workspace are not used to train our AI models.",
            description: "Body copy for the warning about ChatGPT business workspace use",
          },
        }),
        ew = a(81949),
        ej = a(77997),
        eM = function (e) {
          var t = e.onContinue,
            a = (0, v.Z)();
          return (0, c.jsx)(P.Z, {
            isOpen: !0,
            onClose: x.noop,
            type: "success",
            title: a.formatMessage(eS.chatgptTitle),
            description: a.formatMessage(eS.chatgptEnterpriseDescription),
            children: (0, c.jsx)(ex, {
              onClose: function () {
                t();
              },
              scope: r.Workspace,
            }),
          });
        },
        eC = function (e) {
          var t = e.onContinue,
            a = e.onSkip,
            n = (0, v.Z)();
          return (0, c.jsx)(P.Z, {
            isOpen: !0,
            onClose: x.noop,
            type: "success",
            title: n.formatMessage(eS.primaryRoleTitle),
            description: n.formatMessage(eS.tailorChatGPT),
            size: "custom",
            className: "max-w-lg",
            children: (0, c.jsx)(eN, { options: eB, onSkip: a, onSubmit: t }),
          });
        },
        e_ = function (e) {
          var t = e.onContinue,
            a = e.onSkip,
            n = (0, v.Z)();
          return (0, c.jsx)(P.Z, {
            isOpen: !0,
            onClose: x.noop,
            type: "success",
            title: n.formatMessage(eS.workTypeTitle),
            description: n.formatMessage(eS.tailorChatGPT),
            size: "custom",
            className: "max-w-lg",
            children: (0, c.jsx)(eN, { options: eD, onSkip: a, onSubmit: t, multiSelect: !0 }),
          });
        };
      function eN(e) {
        var t = e.options,
          a = e.onSkip,
          n = void 0 === a ? x.noop : a,
          i = e.onSubmit,
          r = void 0 === i ? x.noop : i,
          s = e.multiSelect,
          l = void 0 !== s && s,
          d = function (e, t) {
            var a = e.indexOf(t);
            return -1 === a ? (0, ew._)(e).concat([t]) : (0, ew._)(e.slice(0, a)).concat((0, ew._)(e.slice(a + 1)));
          },
          u = "dark" === (0, ej.F)().resolvedTheme,
          p = (0, v.Z)(),
          m = (0, o._)((0, f.useState)([]), 2),
          g = m[0],
          h = m[1],
          b = (0, f.useCallback)(
            function (e) {
              var t,
                a = null !== (t = e.currentTarget.dataset.value) && void 0 !== t ? t : "";
              l ? h(d(g, a)) : r(a);
            },
            [r, g, h, l]
          );
        return (0, c.jsxs)("div", {
          children: [
            l && (0, c.jsx)("p", { className: "mx-2 text-sm text-gray-400", children: p.formatMessage(eS.selectAll) }),
            (0, c.jsx)("div", {
              className: "flex flex-col items-center justify-center",
              children: (0, c.jsx)("div", {
                className: "flex-wrap space-y-4",
                children: t.map(function (e) {
                  return (0,
                  c.jsx)(ee.z, { onClick: b, color: g.includes(e.id) ? (u ? "light" : "dark") : "neutral", size: "medium", className: "mx-2 ".concat(g.includes(e.id) ? "hover:bg-gray-200" : "hover:bg-gray-100"), "data-value": e.id, children: (0, c.jsx)(T.Z, (0, w._)({}, e.displayValue)) }, e.id);
                }),
              }),
            }),
            (0, c.jsxs)("div", {
              className: "mt-4 flex flex-row justify-end",
              children: [
                (0, c.jsx)(S.mH, { title: p.formatMessage(eS.skipButton), onClick: n }),
                l &&
                  (0, c.jsx)(S.mH, {
                    title: p.formatMessage(eS.continueButton),
                    onClick: function () {
                      r(g);
                    },
                    disabled: 0 === g.length,
                    color: "primary",
                    className: "ml-4",
                  }),
              ],
            }),
          ],
        });
      }
      function eT(e) {
        var t = e.onClose,
          a = (0, o._)((0, f.useState)(0), 2),
          n = a[0],
          i = a[1],
          r = (0, o._)((0, f.useState)({ role: void 0, departments: void 0 }), 2),
          l = r[0],
          d = r[1],
          u = (0, h.ec)(h.F_.workspaceId),
          p = (0, E.kP)().session.user.id,
          m = function () {
            $.m9.logEvent("chatgpt_biz_onboarding_skipped"), t();
          };
        switch (n) {
          case s.InitialModal:
            return (0, c.jsx)(eM, {
              onContinue: function () {
                i(s.RoleModal);
              },
            });
          case s.RoleModal:
            return (0, c.jsx)(eC, {
              onContinue: function (e) {
                d(function (t) {
                  return (0, j._)((0, w._)({}, t), { role: e });
                }),
                  i(s.DepartmentModal);
              },
              onSkip: m,
            });
          case s.DepartmentModal:
            return (0, c.jsx)(e_, {
              onContinue: function (e) {
                var a = (0, j._)((0, w._)({}, l), { departments: e });
                t(),
                  $.m9.logEvent("chatgpt_biz_onboarding_completed"),
                  y.ZP.updateWorkspaceUserOnboardingInformation(u, p, a);
              },
              onSkip: m,
            });
          default:
            return (0, c.jsx)(c.Fragment, {});
        }
      }
      ((i = s || (s = {}))[(i.InitialModal = 0)] = "InitialModal"),
        (i[(i.RoleModal = 1)] = "RoleModal"),
        (i[(i.DepartmentModal = 2)] = "DepartmentModal");
      var eS = (0, b.vU)({
          chatgptTitle: {
            id: "onboarding.chatgptTitle",
            defaultMessage: "ChatGPT",
            description: "Title for the initial onboarding modal",
          },
          chatgptEnterpriseDescription: {
            id: "onboarding.chatgptEnterpriseDescription",
            defaultMessage: "Enterprise Edition",
            description: "Description for the ChatGPT Enterprise Edition",
          },
          primaryRoleTitle: {
            id: "onboarding.primaryRoleTitle",
            defaultMessage: "What's your primary role?",
            description: "Question asking the user about their primary role",
          },
          tailorChatGPT: {
            id: "onboarding.tailorChatGPT",
            defaultMessage: "This will help us tailor ChatGPT for you.",
            description: "Description explaining the reason for the questions",
          },
          workTypeTitle: {
            id: "onboarding.workTypeTitle",
            defaultMessage: "What kind of work do you do?",
            description: "Question asking the user about the kind of work they do",
          },
          selectAll: {
            id: "onboarding.selectAll",
            defaultMessage: "Select all that apply",
            description: "Instruction for multi-select options",
          },
          skipButton: { id: "onboarding.skipButton", defaultMessage: "Skip", description: "Label for the skip button" },
          continueButton: {
            id: "onboarding.continueButton",
            defaultMessage: "Continue",
            description: "Label for the continue button",
          },
        }),
        eP = (0, b.vU)({
          marketing: {
            id: "onboarding.departments.marketing",
            defaultMessage: "Marketing",
            description: "Department option for Marketing",
          },
          analytics: {
            id: "onboarding.departments.analytics",
            defaultMessage: "Data or Analytics",
            description: "Department option for Data or Analytics",
          },
          product: {
            id: "onboarding.departments.product",
            defaultMessage: "Product Management",
            description: "Department option for Product Management",
          },
          comms: {
            id: "onboarding.departments.comms",
            defaultMessage: "Communications",
            description: "Department option for Communication",
          },
          finance: {
            id: "onboarding.departments.finance",
            defaultMessage: "Finance or Accounting",
            description: "Department option for Finance or Accounting",
          },
          customer_experience: {
            id: "onboarding.departments.customer_experience",
            defaultMessage: "Customer Experience",
            description: "Department option for Customer Experience",
          },
          project_management: {
            id: "onboarding.departments.project_management",
            defaultMessage: "Project or Program Management",
            description: "Department option for Project or Program Management",
          },
          engineering: {
            id: "onboarding.departments.engineering",
            defaultMessage: "Engineering",
            description: "Department option for Engineering",
          },
          education_professional: {
            id: "onboarding.departments.education_professional",
            defaultMessage: "Education Professional",
            description: "Department option for Education Professional",
          },
          design: {
            id: "onboarding.departments.design",
            defaultMessage: "Design",
            description: "Department option for Design",
          },
          administrative: {
            id: "onboarding.departments.administrative",
            defaultMessage: "Administrative Assistant",
            description: "Department option for Administrative Assistant",
          },
          partnerships: {
            id: "onboarding.departments.partnerships",
            defaultMessage: "Partnerships",
            description: "Department option for Partnerships",
          },
          it: {
            id: "onboarding.departments.it",
            defaultMessage: "Information Technology (IT)",
            description: "Department option for Information Technology (IT)",
          },
          ops: {
            id: "onboarding.departments.ops",
            defaultMessage: "Operations",
            description: "Department option for Operations",
          },
          human_resources: {
            id: "onboarding.departments.human_resources",
            defaultMessage: "Human Resources",
            description: "Department option for Human Resources",
          },
          research: {
            id: "onboarding.departments.research",
            defaultMessage: "Research & Development",
            description: "Department option for Research & Development",
          },
          sales: {
            id: "onboarding.departments.sales",
            defaultMessage: "Sales",
            description: "Department option for Sales",
          },
          legal: {
            id: "onboarding.departments.legal",
            defaultMessage: "Legal",
            description: "Department option for Legal",
          },
          healthcare: {
            id: "onboarding.departments.healthcare",
            defaultMessage: "Healthcare Professional",
            description: "Department option for Healthcare Professional",
          },
          other: {
            id: "onboarding.departments.other",
            defaultMessage: "Other",
            description: "Department option for Other",
          },
        }),
        eZ = (0, b.vU)({
          team_member: {
            id: "onboarding.role.team_member",
            defaultMessage: "Team Member/ Individual Contributor",
            description: "Label for the role: Team Member/ Individual Contributor",
          },
          manager: {
            id: "onboarding.role.manager",
            defaultMessage: "Manager",
            description: "Label for the role: Manager",
          },
          student: {
            id: "onboarding.role.student",
            defaultMessage: "Student",
            description: "Label for the role: Student",
          },
          executive: {
            id: "onboarding.role.executive",
            defaultMessage: "Executive",
            description: "Label for the role: Executive",
          },
          director: {
            id: "onboarding.role.director",
            defaultMessage: "Director",
            description: "Label for the role: Director",
          },
          business_owner: {
            id: "onboarding.role.business_owner",
            defaultMessage: "Business Owner",
            description: "Label for the role: Business Owner",
          },
          freelancer: {
            id: "onboarding.role.freelancer",
            defaultMessage: "Freelancer",
            description: "Label for the role: Freelancer",
          },
          other: { id: "onboarding.role.other", defaultMessage: "Other", description: "Label for the role: Other" },
        }),
        eB = [
          { id: "team_member", displayValue: eZ.team_member },
          { id: "manager", displayValue: eZ.manager },
          { id: "student", displayValue: eZ.student },
          { id: "executive", displayValue: eZ.executive },
          { id: "director", displayValue: eZ.director },
          { id: "business_owner", displayValue: eZ.business_owner },
          { id: "freelancer", displayValue: eZ.freelancer },
          { id: "other", displayValue: eZ.other },
        ],
        eD = [
          { id: "marketing", displayValue: eP.marketing },
          { id: "analytics", displayValue: eP.analytics },
          { id: "product", displayValue: eP.product },
          { id: "comms", displayValue: eP.comms },
          { id: "engineering", displayValue: eP.engineering },
          { id: "education_professional", displayValue: eP.education_professional },
          { id: "finance", displayValue: eP.finance },
          { id: "customer_experience", displayValue: eP.customer_experience },
          { id: "project_management", displayValue: eP.project_management },
          { id: "design", displayValue: eP.design },
          { id: "administrative", displayValue: eP.administrative },
          { id: "it", displayValue: eP.it },
          { id: "ops", displayValue: eP.ops },
          { id: "human_resources", displayValue: eP.human_resources },
          { id: "research", displayValue: eP.research },
          { id: "sales", displayValue: eP.sales },
          { id: "partnerships", displayValue: eP.partnerships },
          { id: "legal", displayValue: eP.legal },
          { id: "healthcare", displayValue: eP.healthcare },
          { id: "other", displayValue: eP.other },
        ],
        eA = function (e) {
          var t = e.onClose,
            a = (0, v.Z)();
          return (0, c.jsx)(P.Z, {
            isOpen: !0,
            onClose: x.noop,
            type: "success",
            title: "ChatGPT",
            description: a.formatMessage(eI.personalOnboardingSubheading),
            children: (0, c.jsx)(ex, { onClose: t, scope: r.Personal }),
          });
        };
      function eW(e) {
        var t = e.ageVerificationDeadline,
          a = (0, o._)((0, f.useState)(0), 2),
          n = a[0],
          i = a[1],
          s = (0, h.ec)(h.F_.workspaceId),
          l = eh(r.Personal).getHasSeenOnboardingDate,
          d = (0, h.ec)(h.F_.isBusinessWorkspace),
          u = eh(r.Workspace, s).getHasSeenOnboardingDate,
          p = 0 === (0, h.hz)().size ? "loading" : K.b.getCookie(K.c.AgeVerification) || null == t ? "hide" : "show",
          m = 0 === (0, h.hz)().size ? "loading" : "hide",
          g = (0, h.$T)(),
          x = (0, y.Go)(),
          v = (0, h.ec)(h.F_.hasMultipleWorkspaces) && null == s,
          b = (0, f.useMemo)(
            function () {
              return [
                {
                  Component: Q,
                  getModalState: function () {
                    return g ? "loading" : v ? "show" : "hide";
                  },
                },
                {
                  Component: B,
                  getModalState: function () {
                    return g ? "loading" : null !== x ? "show" : "hide";
                  },
                },
                {
                  Component: ec,
                  getModalState: function () {
                    return m;
                  },
                },
                {
                  Component: eA,
                  getModalState: function () {
                    if (d) return "hide";
                    var e = l();
                    return null === e ? "loading" : !1 === e ? "show" : "hide";
                  },
                },
                {
                  Component: eT,
                  getModalState: function () {
                    if (!d) return "hide";
                    var e = u();
                    return null === e ? "loading" : !1 === e ? "show" : "hide";
                  },
                },
                {
                  Component: ea,
                  getModalState: function () {
                    return p;
                  },
                },
              ];
            },
            [g, v, x, m, d, l, u, p]
          );
        (0, f.useEffect)(
          function () {
            b[n] &&
              "hide" === b[n].getModalState() &&
              i(
                b.findIndex(function (e) {
                  return "hide" !== e.getModalState();
                })
              );
          },
          [n, b]
        );
        var k = b[n];
        if (null == k) return null;
        var w = k.getModalState();
        if ("loading" === w) return null;
        "hide" === w &&
          i(function (e) {
            return e + 1;
          });
        var j = b[n].Component;
        return (0, c.jsx)(j, {
          onClose: function () {
            i(function (e) {
              return e + 1;
            });
          },
          ageVerificationDeadline: t,
        });
      }
      var eI = (0, b.vU)({
          personalOnboardingSubheading: {
            id: "BlockingInitialModals.personalOnboardingSubheading",
            defaultMessage: "Tips for getting started",
            description: "Subheading for the Personal onbaording modal",
          },
        }),
        eE = a(6780),
        eV = a(10664),
        eL = function (e) {
          var t = e.action;
          return (0, c.jsxs)("div", {
            className: "flex items-center justify-between overflow-hidden text-gray-600 dark:text-gray-300",
            children: [
              (0, c.jsx)("div", {
                className: "flex flex-shrink items-center overflow-hidden text-sm",
                children: (0, c.jsx)("div", {
                  className: "truncate",
                  children: (0, c.jsx)(T.Z, (0, w._)({}, t.actionMessageDescriptor)),
                }),
              }),
              (0, c.jsx)("div", {
                className: "ml-3 flex flex-row gap-2",
                children: (0, eV.A3)(t.keyboardBinding).map(function (e, a) {
                  return (0, c.jsx)(eq, { keyName: e }, "".concat(t.key, "-").concat(a));
                }),
              }),
            ],
          });
        },
        eq = function (e) {
          var t = e.keyName,
            a = (0, V.default)(
              "my-2 flex h-8 items-center justify-center rounded-[4px] border border-black/10 capitalize text-gray-600 dark:border-white/10 dark:text-gray-300"
            );
          return t.length > 1
            ? t.length > 3
              ? (0, c.jsx)("div", {
                  className: (0, V.default)(a, "min-w-[50px]"),
                  children: (0, c.jsx)("span", { className: "text-xs", children: t }),
                })
              : (0, c.jsx)("div", {
                  className: (0, V.default)(a, "min-w-[32px]"),
                  children: (0, c.jsx)("span", { className: "text-xs", children: t }),
                })
            : (0, c.jsx)("div", {
                className: (0, V.default)(a, "min-w-[32px]"),
                children: (0, c.jsx)("span", { className: "text-sm", children: t }),
              });
        },
        eO = (0, b.vU)({
          keyboardActionsModalTitle: {
            id: "KeyboardActionsModal.keyboardActionsModalTitle",
            defaultMessage: "Keyboard shortcuts",
            description: "Title of the keyboard shortcuts modal",
          },
        }),
        eR = function () {
          var e = (0, v.Z)(),
            t = (0, Y.tN)(function (e) {
              return e.activeModals.has(Y.B.KeyboardActions);
            }),
            a = function () {
              Y.vm.closeModal(Y.B.KeyboardActions);
            },
            n = (0, eV.JS)(),
            i = (0, f.useMemo)(
              function () {
                var e = Math.ceil(n.length / 2);
                return [n.slice(0, e), n.slice(e)];
              },
              [n]
            );
          return (0, c.jsx)(P.Z, {
            isOpen: t,
            onClose: a,
            type: "success",
            size: "custom",
            className: "md:max-w-[672px] lg:max-w-[796px] xl:max-w-4xl",
            closeButton: (0, c.jsx)(S.ZP.CloseButton, { onClose: a }),
            title: e.formatMessage(eO.keyboardActionsModalTitle),
            children: (0, c.jsx)(c.Fragment, {
              children: (0, c.jsx)("div", {
                className: "grid grid-flow-row grid-cols-[repeat(auto-fit,minmax(250px,1fr))] gap-x-9",
                children: i.map(function (e, t) {
                  return (0, c.jsx)(
                    "div",
                    {
                      className: "flex flex-col overflow-hidden",
                      children: e.map(function (e) {
                        return (0, c.jsx)(eL, { action: e }, e.key);
                      }),
                    },
                    "col-".concat(t)
                  );
                }),
              }),
            }),
          });
        },
        eG = Symbol("invalid path");
      function ez(e) {
        var t,
          a = e.split(/[#?]/)[0];
        if ("/" !== a) {
          var n = /\/c\/([a-f0-9-]+)/.exec(a);
          return null !== (t = null == n ? void 0 : n[1]) && void 0 !== t ? t : eG;
        }
      }
      function eU(e) {
        var t = e.urlThreadId,
          a = e.clientThreadId,
          n = e.isUserInCanPayGroup,
          i = e.serviceStatus,
          r = e.serviceAnnouncement,
          s = e.ageVerificationDeadline,
          x = (0, o._)(
            (0, f.useState)(function () {
              return void 0 !== t ? t : void 0 !== a ? a : (0, g.OX)();
            }),
            2
          ),
          v = x[0],
          b = x[1];
        void 0 !== t && v !== t && g.tQ.getServerThreadId(v) !== t && b(t),
          void 0 === t && void 0 !== g.tQ.getServerThreadId(v) && b((0, g.OX)());
        var y = (0, h.$T)(),
          k = (0, h.WY)(),
          w = (0, h.ec)(h.F_.workspaceId),
          j = (0, d.g)(function (e) {
            return e.updateFlagValue;
          }),
          M = (0, h.hz)(),
          C = M.has(m.PL),
          _ = M.has(m.rX);
        (0, f.useEffect)(
          function () {
            C && (p.Z.setPrefetchEnabled(_), p.Z.gatherData());
          },
          [C, _]
        ),
          (0, f.useEffect)(
            function () {
              void 0 !== n && j("isUserInCanPayGroup", n);
            },
            [j, n]
          ),
          (0, f.useEffect)(
            function () {
              (null == i ? void 0 : i.type) && !1 === k && l.m.warning(i.message, { hasCloseButton: !0, duration: 5 });
            },
            [k, null == i ? void 0 : i.message, null == i ? void 0 : i.type]
          );
        var N = (0, f.useRef)(!1);
        return (
          (0, f.useEffect)(
            function () {
              if (!y) {
                var e = k ? r.paid : r.public;
                if ((null == e ? void 0 : e.type) && (null == e ? void 0 : e.message) && !N.current) {
                  N.current = !0;
                  var t = e.message,
                    a = { hasCloseButton: !0, duration: 15 };
                  switch (e.type) {
                    case "danger":
                      l.m.danger(t, a);
                      break;
                    case "info":
                      l.m.info(t, a);
                      break;
                    case "warning":
                      l.m.warning(t, a);
                  }
                }
              }
            },
            [r, y, k]
          ),
          (0, c.jsxs)(u.gB.Provider, {
            value: null,
            children: [
              (0, c.jsx)(eW, { ageVerificationDeadline: s }, w),
              (0, c.jsx)(eR, {}),
              (0, c.jsx)(eE.Z, { clientThreadId: v, setClientThreadId: b }),
            ],
          })
        );
      }
    },
    6780: function (e, t, a) {
      a.d(t, {
        Z: function () {
          return W;
        },
      });
      var n = a(39324),
        i = a(35250),
        r = a(13995),
        s = a(55344),
        o = a.n(s),
        c = a(60554),
        l = a(70079),
        d = a(1454),
        u = a(32004),
        p = a(94968),
        f = a(37469),
        m = a(46020),
        g = a(78931),
        h = a(32542),
        x = a(28735),
        v = a(10664),
        b = a(33669),
        y = a(2166),
        k = a(41932),
        w = a(61402),
        j = a(67),
        M = a(20522),
        C = a(80267),
        _ = a(70517),
        N = a(82816),
        T = a(52481),
        S = a(82277),
        P = a(13090),
        Z = a(14099),
        B = a(42569),
        D = o()(
          function () {
            return Promise.all([a.e(8682), a.e(8107)])
              .then(a.bind(a, 737))
              .then(function (e) {
                return e.GizmoDiscordSidebar;
              });
          },
          {
            loadableGenerated: {
              webpack: function () {
                return [737];
              },
            },
          }
        ),
        A = o()(
          function () {
            return Promise.all([a.e(8682), a.e(8238)])
              .then(a.bind(a, 63018))
              .then(function (e) {
                return e.GizmoSidebarList;
              });
          },
          {
            loadableGenerated: {
              webpack: function () {
                return [63018];
              },
            },
          }
        );
      function W(e) {
        var t,
          n = e.clientThreadId,
          s = e.setClientThreadId,
          o = e.initiallyHighlightedMessageId,
          u = e.continueConversationUrl,
          p = null !== (0, l.useContext)(h.gB);
        (0, f.ax)(n);
        var y = (0, f.XK)(n),
          k = (0, c.useRouter)(),
          W = (0, g.hz)(),
          E = (0, f.UL)(n),
          V = (0, l.useContext)(h.QL).historyDisabled,
          L = (0, B.Xy)(E.lastModelUsed, n),
          q = (0, r.NL)();
        (0, l.useEffect)(
          function () {
            return (
              f.tQ.retainThread(n),
              function () {
                setTimeout(function () {
                  q.invalidateQueries(["conversation", n]);
                }, 0),
                  f.tQ.releaseThread(n);
              }
            );
          },
          [n, q]
        ),
          (0, l.useEffect)(
            function () {
              m.vm.closeSharingModal();
            },
            [n, y]
          );
        var O = (0, l.useCallback)(
          function () {
            s((0, f.OX)()),
              k.replace(L.tags.includes(B.S.GPT_4) ? "/" : "/?model=".concat(L.id), void 0, { shallow: !0 });
          },
          [s, L.tags, L.id, k]
        );
        (0, v.yx)({ resetThreadAction: O, clientThreadId: n });
        var R = (0, m.tN)(function (e) {
            return e.activeSidebar;
          }),
          G = (0, b.w$)();
        (0, l.useEffect)(
          function () {
            return function () {
              w.hx.abortAllRequests();
            };
          },
          [n]
        ),
          (t = (0, g.hz)().has("debug")),
          (0, l.useEffect)(
            function () {
              if (t)
                return (0, x.eR)(document, {
                  keydown: function (e) {
                    (e.target instanceof HTMLElement &&
                      ["input", "textarea", "select", "button"].includes(e.target.tagName.toLowerCase())) ||
                      "\\" !== e.key ||
                      m.vm.toggleActiveSidebar("debug");
                  },
                });
            },
            [t]
          );
        var z = (0, l.useRef)(E.threadId);
        (0, l.useEffect)(
          function () {
            E.threadId !== z.current && (m.vm.setActiveSidebar(!1), (z.current = E.threadId)), w.hx.clear();
          },
          [E.threadId]
        );
        var U = (0, g.ec)(function (e) {
            return e.currentWorkspace;
          }),
          H = null == U ? void 0 : U.id,
          F = (0, M.Ml)(),
          Q = (0, l.useCallback)(
            function (e) {
              F &&
                null != H &&
                Promise.all([a.e(8682), a.e(5663)])
                  .then(a.bind(a, 60790))
                  .then(function (t) {
                    return t.gizmoCreateGPTCompletionCallback(e, H, k, s);
                  });
            },
            [F, H, k, s]
          ),
          X = (0, M.bU)(function (e) {
            return e.displayVariant;
          });
        return (0, i.jsxs)(i.Fragment, {
          children: [
            F &&
              X !== M.Mo.Discord &&
              X !== M.Mo.SidebarList &&
              (0, i.jsx)(j.m, {
                className: "pointer-events-none invisible absolute left-3 top-3 z-50 md:pointer-events-auto md:visible",
              }),
            (0, i.jsxs)(S.Z, {
              showNavigation: !p,
              renderTitle: (0, i.jsx)(I, { clientThreadId: n }),
              renderMobileHeaderRightContent: (0, i.jsx)(P.js, {
                onClick: O,
                children: V ? (0, i.jsx)(d.Bw1, { className: "icon-lg" }) : (0, i.jsx)(d.OvN, { className: "icon-lg" }),
              }),
              renderSidebar:
                F && X === M.Mo.Discord
                  ? (0, i.jsx)(D, { clientThreadId: n })
                  : (0, i.jsx)(P.l6, {
                      children: (0, i.jsxs)(_.Z, {
                        onNewThread: O,
                        children: [
                          F && X === M.Mo.SidebarList ? (0, i.jsx)(A, {}) : null,
                          (0, i.jsx)(C.Z, { activeId: V ? void 0 : y, onNewThread: O }),
                        ],
                      }),
                    }),
              children: [
                (0, i.jsx)(
                  Z.Z,
                  {
                    initialThreadData: E,
                    clientThreadId: n,
                    initiallyHighlightedMessageId: o,
                    continueConversationUrl: u,
                    onCompletionFinished: Q,
                  },
                  n
                ),
                (0, i.jsxs)(S.Z.Sidebars, {
                  children: [
                    W.has("debug") &&
                      "debug" === R &&
                      (0, i.jsx)(T.fv, {
                        clientThreadId: n,
                        slideOver: !G,
                        onClose: function () {
                          return m.vm.toggleActiveSidebar("debug");
                        },
                        isOpen: !0,
                      }),
                    W.has("tools3_dev") && (0, i.jsx)(N.ZP, { slideOver: !G }),
                  ],
                }),
              ],
            }),
          ],
        });
      }
      function I(e) {
        var t,
          a = e.clientThreadId,
          r = null !== (t = f.tQ.getTitle(a)) && void 0 !== t ? t : "New chat",
          s = (0, y.Z)(a, r, !0),
          o = s.resolvedTitle,
          c = s.isTypingEffect,
          p = (0, l.useContext)(h.QL),
          m = p.historyDisabled,
          g = p.toggleHistoryDisabled;
        return (0, i.jsx)(i.Fragment, {
          children: m
            ? (0, i.jsxs)("button", {
                className: "flex cursor-pointer flex-row place-items-center items-center justify-center gap-3",
                onClick: function () {
                  return g();
                },
                children: [
                  (0, i.jsx)(d.$IY, { className: "icon-sm" }),
                  (0, i.jsx)(u.Z, (0, n._)({}, E.enableChatHistory)),
                ],
              })
            : c && null != o
            ? (0, i.jsx)(k.Z, { text: o })
            : null != o
            ? o
            : (0, i.jsx)(u.Z, (0, n._)({}, E.newChat)),
        });
      }
      var E = (0, p.vU)({
        enableChatHistory: {
          id: "navigation.enableChatHistory",
          defaultMessage: "Enable chat history",
          description: "Enable chat history button label",
        },
        newChat: { id: "navigation.newChat", defaultMessage: "New chat", description: "New chat header title" },
      });
    },
    67: function (e, t, a) {
      a.d(t, {
        X: function () {
          return l;
        },
        m: function () {
          return d;
        },
      });
      var n = a(4337),
        i = a(35250),
        r = a(19841),
        s = a(9181),
        o = a.n(s);
      function c() {
        var e = (0, n._)(["rounded-full bg-black dark:bg-gray-100"]);
        return (
          (c = function () {
            return e;
          }),
          e
        );
      }
      var l = a(21389).Z.div(c());
      function d(e) {
        var t = e.className;
        return (0, i.jsx)(o(), {
          href: "/",
          shallow: !0,
          className: (0, r.default)("block h-8 w-8 cursor-pointer", t),
          children: (0, i.jsx)(l, { className: "h-full w-full" }),
        });
      }
    },
  },
]);
