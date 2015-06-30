package com.github.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;

public class FragmentUtils {

	public static String getFragmentName(Fragment fragment) {
		String tag = fragment.getClass().getName();
		return tag;
	}

	public static Fragment getFragment(FragmentManager fgmgr, String tag) {
		if (fgmgr != null) {
			return fgmgr.findFragmentByTag(tag);
		}
		return null;
	}

	public static void addFragment(FragmentManager fgmgr, Fragment fragment,
			int anchorRid) {
		if (fgmgr == null || fragment == null || anchorRid == -1) {
			System.out.println("addFragment null");
			return;
		}
		// 当Activity销毁后commitAllowingStateLoss会报错
		try {
			System.out.println("addFragment not null");
			String tag = ((Object) fragment).getClass().getName();
			FragmentTransaction tran = fgmgr.beginTransaction();
			tran.add(anchorRid, fragment, tag);
			tran.commitAllowingStateLoss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addFragmentWithAnim(FragmentManager fgmgr,
			Fragment fragment, int anchorRid, int enterAnim, int exitAnim,
			int popEnterAnim, int popExitAnim) {
		if (fgmgr == null || fragment == null || anchorRid == -1) {
			return;
		}
		// 当Activity销毁后commitAllowingStateLoss会报错
		try {
			String tag = ((Object) fragment).getClass().getName();
			FragmentTransaction tran = fgmgr.beginTransaction();
			tran.setCustomAnimations(enterAnim, exitAnim, popEnterAnim,
					popExitAnim);
			tran.add(anchorRid, fragment, tag);
			tran.commitAllowingStateLoss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addFragmentToBackStack(FragmentManager fgmgr,
			Fragment fragment, int anchorRid) {
		if (fgmgr == null || fragment == null || anchorRid == -1) {
			return;
		}
		// 当Activity销毁后commitAllowingStateLoss会报错
		try {
			String tag = ((Object) fragment).getClass().getName();
			FragmentTransaction tran = fgmgr.beginTransaction();
			tran.add(anchorRid, fragment, tag);
			tran.addToBackStack(tag);
			tran.commitAllowingStateLoss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addFragmentToBackStackWithAnim(FragmentManager fgmgr,
			Fragment fragment, int anchorRid, int enterAnim, int exitAnim,
			int popEnterAnim, int popExitAnim) {
		if (fgmgr == null || fragment == null || anchorRid == -1) {
			return;
		}
		// 当Activity销毁后commitAllowingStateLoss会报错
		try {
			String tag = ((Object) fragment).getClass().getName();
			FragmentTransaction tran = fgmgr.beginTransaction();
			tran.setCustomAnimations(enterAnim, exitAnim, popEnterAnim,
					popExitAnim);
			tran.add(anchorRid, fragment, tag);
			tran.addToBackStack(tag);
			tran.commitAllowingStateLoss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean isFragmentExist(FragmentManager fgmgr, String tag) {
		if (fgmgr == null || TextUtils.isEmpty(tag)) {
			return false;
		}
		Fragment tmpFrag = fgmgr.findFragmentByTag(tag);
		return (tmpFrag != null);
	}

	public static void removeFragment(FragmentManager fgmgr, Fragment fragment) {
		if (fgmgr == null || fragment == null) {
			return;
		}
		// 当Activity销毁后commitAllowingStateLoss会报错
		try {
			FragmentTransaction tran = fgmgr.beginTransaction();
			tran.remove(fragment);
			tran.commitAllowingStateLoss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void replaceFragment(FragmentManager fgmgr,
			Fragment fragment, int anchorRid) {
		if (fgmgr == null || fragment == null || anchorRid == -1) {
			return;
		}
		// 当Activity销毁后commitAllowingStateLoss会报错
		try {
			String tag = ((Object) fragment).getClass().getName();
			FragmentTransaction tran = fgmgr.beginTransaction();
			tran.replace(anchorRid, fragment, tag);
			tran.commitAllowingStateLoss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void replaceFragmentWithAnim(FragmentManager fgmgr,
			Fragment fragment, int anchorRid, int enterAnim, int exitAnim,
			int popEnterAnim, int popExitAnim) {
		if (fgmgr == null || fragment == null || anchorRid == -1) {
			return;
		}
		// 当Activity销毁后commitAllowingStateLoss会报错
		try {
			String tag = ((Object) fragment).getClass().getName();
			FragmentTransaction tran = fgmgr.beginTransaction();
			tran.setCustomAnimations(enterAnim, exitAnim, popEnterAnim,
					popExitAnim);
			tran.replace(anchorRid, fragment, tag);
			tran.commitAllowingStateLoss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
