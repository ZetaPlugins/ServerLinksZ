![banner](https://cdn.modrinth.com/data/cached_images/b1a659a750a37515bf4c4c767ccdfe9a7c3fe038.png)

![paper](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact/supported/paper_vector.svg)
![purpur](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact/supported/purpur_vector.svg)
[![github](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact/available/github_vector.svg)](https://github.com/KartoffelChipss/ServerLinksZ)
[![modrinth](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact/available/modrinth_vector.svg)](https://modrinth.com/plugin/serverlinksz)
[![docs](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact/documentation/gitbook_vector.svg)](https://docs.zetaplugins.com/serverlinksz)
[![discord-plural](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact/social/discord-plural_vector.svg)](https://strassburger.org/discord)
[![generic-plural](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact/translate/generic-plural_vector.svg)](https://gitlocalize.com/repo/9890)

ServerLinksZ is a simple plugin, that allows you to add Links to the "Server Links" page in the pause menu. ServerLinksZ also adds a command for users to quickly look up links like /discord.

## Features
- ✅ Custom links
- ✅ Colored link Names
- ✅ HEX Colors
- ✅ Link commands (e.g. `/discord`, `/website`)
- ✅ Highly customizable
- ✅ Easy setup
- ✅ Multiple languages

## Commands

- **/sl help** - Open the help menu
- **/sl add <id> <name> <url> <allowCommand?>** - Add a link to the Link page
- **/sl remove <id>** - Remove the link with this id
- **/sl reload** - Reload the plugin
- **/link <id>** - Open a link with this id 

and custom link commands (e.g. `/discord`, `/website`)

## Permissions

- **serverlinksz.admin** - Allows a user to manage links and do admin tasks (default: op)

## Config

Here is an example of the configuration file:
<details>
<summary>config.yml</summary>

```yml
#     _____                            _      _       _          ______
#    / ____|                          | |    (_)     | |        |___  /
#   | (___   ___ _ ____   _____ _ __  | |     _ _ __ | | _____     / /
#   \___ \ / _ \ '__\ \ / / _ \ '__| | |    | | '_ \| |/ / __|   / /
#   ____) |  __/ |   \ V /  __/ |    | |____| | | | |   <\__ \  / /__
#  |_____/ \___|_|    \_/ \___|_|    |______|_|_| |_|_|\_\___/ /_____|


# === COLOR CODES ===

# This plugin supports old color codes like: &c, &l, &o, etc.
# It also supports MiniMessage, a more advanced way to format messages:
# https://docs.advntr.dev/minimessage/format.html
# With MiniMessage, you can add HEX colors, gradients, hover and click events, etc.


# === GENERAL SETTINGS ===

# Set the language to any code found in the "lang" folder (don't add the .yml extension)
# You can add your own language files. Use https://github.com/KartoffelChipss/ServerLinksZ/tree/main/src/main/resources/lang/en-US.yml as a template
# If you want to share your language file, either create a pull request on GitHub or use GitLocalize: https://gitlocalize.com/repo/9890
#  | en-US | de-DE | zh-CN | ru-RU | zh-TW
lang: "en-US"

# Wether to show hints when using commands
hints: true

# Add a /link command to view the links
linkCommand: true

# Instead of using the /link command, you can also use a custom command for any link (e.g. /mycoollink)
# This feature is experimental and might not work as expected
dynamicCommands: false

# [!!!] You can configure the links in the links.yml file!
```
</details>

And here an example of the links configuration file:

<details>
<summary>links.yml</summary>

```yml
discord:
  name: "<#7289da>&lDiscord"
  url: "https://strassburger.org/discord"
  type: CUSTOM
  allowCommand: true
website:
  name: "<#7cd770>&lWebsite"
  url: "https://modrinth.com/plugin/serverlinksz"
  type: CUSTOM
  allowCommand: false
bugreport:
  name: "<#ff746c>&lReport a bug"
  url: "https://example.com/issues"
  # The type can be any of ANNOUNCEMENTS, COMMUNITY, COMMUNITY_GUIDELINES, FEEDBACK, FORUMS, NEWS, REPORT_BUG, STATUS, SUPPORT, WEBSITE, CUSTOM
  # CUSTOM will display the name in the links menu. Anything else will display a client side defined label.
  type: REPORT_BUG
  allowCommand: true
```
</details>

## Support

If you need help with the setup of the plugin, you can join my Discord:

[![discord-plural](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact/social/discord-plural_vector.svg)](https://strassburger.org/discord)

---

[![Usage](https://bstats.org/signatures/bukkit/ServerLinksZ.svg)](https://bstats.org/plugin/bukkit/ServerLinksZ/22795)
