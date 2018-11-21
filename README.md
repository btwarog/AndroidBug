# AndroidBug
### Proof of concept for weird behaviour of Android OS.


Steps to reproduction:
1. Turn on "Don't keep activities under System settings"
2. Go to ProfileActivity
3. Clear logs
4. Go to EditProfileFragment( through menu options)
5. Minimaze app.
6. Return to the app.
7. Compare Lifecycle logs

#### For result you should be able to see that EditFragment in one variant kept *mainTitle* value passed with construcort in other one it returned to default as data wasn't saved to bundle and restored from it

Below you can find logs from my device, it was the same on Marshmallow and Oreo.
1. Situation when method form **BaseActivity** *shouldKillBundle()* returns true
`11-21 21:17:43.161 4719-4719/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onAttach EditFragment
11-21 21:17:43.161 4719-4719/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onCreate EditFragment
11-21 21:17:43.161 4719-4719/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onPause PreviewFragment
11-21 21:17:43.161 4719-4719/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onDestroyView PreviewFragment
11-21 21:17:43.161 4719-4719/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onCreateView EditFragment
11-21 21:17:43.162 4719-4719/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onViewCreated EditFragment
11-21 21:17:43.162 4719-4719/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onActivityCreated EditFragment
11-21 21:17:43.162 4719-4719/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onStar EditFragment
11-21 21:17:43.162 4719-4719/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onResume EditFragment
11-21 21:17:43.162 4719-4719/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onResume Setted EditFragment
11-21 21:17:44.528 4719-4719/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onPause EditFragment
11-21 21:17:44.528 4719-4719/pl.btwarog.apptest D/AppTest: Activity Lifecycle #onPause ProfileActivity
11-21 21:17:44.585 4719-4719/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onSaveInstanceState PreviewFragment
11-21 21:17:44.585 4719-4719/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onSaveInstanceState EditFragment
11-21 21:17:44.617 4719-4719/pl.btwarog.apptest D/AppTest: Activity Lifecycle #onSaveInstanceState ProfileActivity
11-21 21:17:47.172 4719-4719/pl.btwarog.apptest D/AppTest: Activity Lifecycle #onRestart ProfileActivity
11-21 21:17:47.172 4719-4719/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onStar EditFragment
11-21 21:17:47.172 4719-4719/pl.btwarog.apptest D/AppTest: Activity Lifecycle #onStart ProfileActivity
11-21 21:17:47.172 4719-4719/pl.btwarog.apptest D/AppTest: Activity Lifecycle #onResume ProfileActivity
11-21 21:17:47.172 4719-4719/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onResume EditFragment
11-21 21:17:47.172 4719-4719/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onResume Setted EditFragment
`

2. Situation when method from **BaseActivity** *shoudKillBundle()* returns falase:
`11-21 21:20:04.512 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onAttach EditFragment
11-21 21:20:04.512 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onCreate EditFragment
11-21 21:20:04.513 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onPause PreviewFragment
11-21 21:20:04.513 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onDestroyView PreviewFragment
11-21 21:20:04.514 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onCreateView EditFragment
11-21 21:20:04.516 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onViewCreated EditFragment
11-21 21:20:04.516 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onActivityCreated EditFragment
11-21 21:20:04.516 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onStar EditFragment
11-21 21:20:04.516 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onResume EditFragment
11-21 21:20:04.516 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onResume Setted EditFragment
11-21 21:20:05.976 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onPause EditFragment
11-21 21:20:05.976 4841-4841/pl.btwarog.apptest D/AppTest: Activity Lifecycle #onPause ProfileActivity
11-21 21:20:06.009 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onSaveInstanceState PreviewFragment
11-21 21:20:06.009 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onSaveInstanceState EditFragment
11-21 21:20:06.009 4841-4841/pl.btwarog.apptest D/AppTest: Activity Lifecycle #onSaveInstanceState ProfileActivity
11-21 21:20:06.289 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onDestroy PreviewFragment
11-21 21:20:06.289 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onDetach PreviewFragment
11-21 21:20:06.289 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onDestroyView EditFragment
11-21 21:20:06.303 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onDestroy EditFragment
11-21 21:20:06.303 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onDetach EditFragment
11-21 21:20:06.303 4841-4841/pl.btwarog.apptest D/AppTest: Activity Lifecycle #onDestroy ProfileActivity
11-21 21:20:09.254 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onAttach PreviewFragment
11-21 21:20:09.255 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onCreate PreviewFragment
11-21 21:20:09.255 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onAttach EditFragment
11-21 21:20:09.255 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onCreate EditFragment
11-21 21:20:09.255 4841-4841/pl.btwarog.apptest D/AppTest: Activity Lifecycle #onCreate ProfileActivity
11-21 21:20:09.285 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onCreateView EditFragment
11-21 21:20:09.285 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onViewCreated EditFragment
11-21 21:20:09.285 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onActivityCreated EditFragment
11-21 21:20:09.286 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onStar EditFragment
11-21 21:20:09.286 4841-4841/pl.btwarog.apptest D/AppTest: Activity Lifecycle #onStart ProfileActivity
11-21 21:20:09.296 4841-4841/pl.btwarog.apptest D/AppTest: Activity Lifecycle #onResume ProfileActivity
11-21 21:20:09.296 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onResume EditFragment
11-21 21:20:09.296 4841-4841/pl.btwarog.apptest D/AppTest: Fragment Lifecycle #onResume NotSetted EditFragment
`
