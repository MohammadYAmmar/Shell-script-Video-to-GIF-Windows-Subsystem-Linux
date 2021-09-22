#!/bin/bash
#Shell script to convert video to GIF v9 | 8-9-2021
#By: Eng. Mohammad Yaser Ammar
#GitHub: https://github.com/
#Linkedin: https://www.linkedin.com/in/mohammad-y-ammar/
"""
#Help section
if [ $var = "help" ] || [ $var = "h" ]
then
  echo "help of script "
  exit
fi
"""
#1 - Best case scenario:
ffmpeg
wait #Until the above operations are finished
#todo describe
cpstatus=$?

if [ "$cpstatus" == 0 ]; then
ffmpeg -i *.mp4 output_GIF.gif
echo "complete"
exit
#2 - Worst scenario: If not install
else 
echo "not complete"
wait

#Now it moves according to the error code
app="ffmpeg"

#todo from unme after that ask user with Check if a String Contains a Substring in Bash
distro=$1 #first parameter after shell

System=uname -a
Substring ='Linux'
if [[ "$Text" == *"$Substring"* ]]; then
  echo "Yes is contain $Substring"
fi
#todo make conditions to save in distro value

#todo more option and help
if [ -z $1 ]
then
distro="known"
fi

#case
case $distro in
"slackware") slackpkg install $app;;
"ubuntu"|"debian"|"linuxmint"|"kalilinux") 
sudo add-apt-repository ppa:mc3man/trusty-media
sudo apt-get update
sudo apt-get install $app;;
#sudo apt-get install $app;;
"archlinux"|"chakra"|"manjora") sudo pacman -S $app;;
"opensusu") sudo zypper install $app;;
"fedora") sudo yum install $app;;
linux*) sudo apt-get install $app;;# case support wildcard * ?
*) echo "$distro is not supportd";;
esac # oppsite case
fi
wait # Until the above operations are finished
#It is necessary in the first condition 
#to check whether the program exists or not, 
#and accordingly it enters the download, 
#and if it becomes an error, it acts

#ffmpeg -i input_video_file output.gif
ffmpeg -i *.mp4 output.gif