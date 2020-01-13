package com.example.odbpoc;

import com.sun.jna.*;

import static com.example.odbpoc.Constants.windoslibName;

public interface simpleDLL extends Library {
		//String windoslibName ="kernel32";
		String linuxlibName ="kernel32";
		simpleDLL INSTANCE = Native.load(
				(Platform.isWindows() ? windoslibName : linuxlibName), simpleDLL.class);

		int AddStep(int numStep);
	//		void GetSystemTime(SYSTEMTIME result);

	}